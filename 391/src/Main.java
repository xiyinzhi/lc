import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // brute force
    // Memory Limit Exceeded
    // Time:O(n) Space:O((maxX - minX)*(maxY - minY))
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return false;
        }
        int n = rectangles.length;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minX = Math.min(minX, rectangles[i][0]);
            minY = Math.min(minY, rectangles[i][1]);
            maxX = Math.max(maxX, rectangles[i][2]);
            maxY = Math.max(maxY, rectangles[i][3]);
        }
        boolean[][] visited = new boolean[maxX - minX][maxY - minY];
        for (int i = 0; i < n; i++) {
            for (int x = rectangles[i][0] - minX; x < rectangles[i][2] - minX; x++) {
                for (int y = rectangles[i][1] - minY; y < rectangles[i][3] - minY; y++) {
                    if (visited[x][y]) {
                        return false;
                    } else {
                        visited[x][y] = true;
                    }
                }
            }
        }
        for (int i = 0; i < maxX - minX; i++) {
            for (int j = 0; j < maxY - minY; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * smart solution
     * basic idea:
     * successful:
     * 1. total area sums = area of the final rectangle
     * 2. 4 corner points of the final rectangle could only appear once, and all points appear once are the 4 corner points
     * 可以用hashmap，value存每个点出现次数，也可以直接用set，因为所有overlap的点出现频率都会是偶数次
     */
    // Time:O(n) Space:O(n)
    public boolean isRectangleCover2(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) {
            return false;
        }
        int n = rectangles.length;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        long area = 0L;
        for (int i = 0; i < n; i++) {
            minX = Math.min(minX, rectangles[i][0]);
            minY = Math.min(minY, rectangles[i][1]);
            maxX = Math.max(maxX, rectangles[i][2]);
            maxY = Math.max(maxY, rectangles[i][3]);
            area += ((long) rectangles[i][2] - (long) rectangles[i][0]) * ((long) rectangles[i][3] - (long) rectangles[i][1]);
            String s1 = rectangles[i][0] + "," + rectangles[i][1];
            String s2 = rectangles[i][0] + "," + rectangles[i][3];
            String s3 = rectangles[i][2] + "," + rectangles[i][1];
            String s4 = rectangles[i][2] + "," + rectangles[i][3];
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        if ((long) (maxY - minY) * (long) (maxX - minX) == area && set.size() == 4 && set.contains(minX + "," + minY) && set.contains(minX + "," + maxY) && set.contains(maxX + "," + minY) && set.contains(maxX + "," + maxY)) {
            return true;
        } else {
            return false;
        }
    }
}
