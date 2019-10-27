import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Method 1: build a new class to record every point, increased space complexity
    // Time:O(nlogK) Space:O(n+K)
    public int[][] kClosest(int[][] points, int K) {
        List<Point> pointList = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            Point point = new Point(points[i][0], points[i][1]);
            pointList.add(point);
        }
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(K, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return p1.x * p1.x + p1.y * p1.y - p2.x * p2.x - p2.y * p2.y;
            }
        });
        for (int i = 0; i < n; i++) {
            priorityQueue.add(pointList.get(i));
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            Point p = priorityQueue.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }

    // Method 2: build a new class to record every point, increased space complexity
    // Time:O(nlogK) Space:O(K)
    public int[][] kClosest2(int[][] points, int K) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(points[i]);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] point = pq.poll();
            res[i][0] = point[0];
            res[i][1] = point[1];
        }
        return res;
    }
}
