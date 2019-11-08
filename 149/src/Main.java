import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] points = {{0, 0}, {1, 1}, {2, 2}};
        System.out.println(main.maxPoints2(points));
//        Set<int[]> set = new HashSet<>();
//        int[] a = {1,2};
//        int[] b = {1,2};
//        set.add(a);
//        set.add(b);
//        System.out.println(set.size());
    }

    /**
     * 本题最优解也需O(n^2)时间
     * 注意两个大edge case: 1.线是垂直的，没有斜率 2.点重合
     * 小: 1.只有一个点（可能出现n次）2.map里value最大的不一定是点最多的 3.考虑斜率为0的情况
     * 注意用 double/float 代表 slope,intercept 因为有精度损失，所以是无法AC的，
     * 需要用 Euclidean Algorithm 求最小公约数 greatest common divisor (gcd)
     * 已AC，但很慢
     */
    // 用double/float只能过31/37
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        Map<String, Integer> pointMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp = points[i][0] + "," + points[i][1];
            pointMap.put(temp, pointMap.getOrDefault(temp, 0) + 1);
        }
        if (pointMap.size() == 1) {
            for (String key : pointMap.keySet()) {
                return pointMap.get(key);
            }
        }
        Map<String, Integer> infoMap = new TreeMap<>();
        Map<String, Integer> recordMap = new TreeMap<>();
        for (String str1 : pointMap.keySet()) {
            for (String str2 : pointMap.keySet()) {
                if (!str1.equals(str2)) {
                    String[] s1 = str1.split(",");
                    String[] s2 = str2.split(",");
                    int x1 = Integer.parseInt(s1[0]);
                    int y1 = Integer.parseInt(s1[1]);
                    int x2 = Integer.parseInt(s2[0]);
                    int y2 = Integer.parseInt(s2[1]);
                    StringBuilder sb = new StringBuilder();
                    if (x1 == x2) {
                        sb = sb.append(x1);
                    } else {
                        int gcd1 = Math.abs(gcd(y2 - y1, x2 - x1));
                        int k1 = (y2 - y1) / gcd1;
                        int k2 = (x2 - x1) / gcd1;
                        if (k1 > 0 ^ k2 > 0 && k1 != 0) {
                            sb.append("-");
                        }
                        sb.append(Math.abs(k1)).append("/").append(Math.abs(k2)).append(",");
                        int gcd2 = Math.abs(gcd(y1 * k2 - k1 * x1, k2));
                        int b1 = (y1 * k2 - k1 * x1) / gcd2;
                        int b2 = k2 / gcd2;
                        if (b1 > 0 ^ b2 > 0 && b1 != 0) {
                            sb.append("-");
                        }
                        sb.append(Math.abs(b1)).append("/").append(Math.abs(b2));
                    }
                    String key = sb.toString();
                    infoMap.put(key, infoMap.getOrDefault(key, 0) + pointMap.get(str1));
                    recordMap.put(key, recordMap.getOrDefault(key, 0) + 1);
                }
            }
        }
        int maxPoints = 0;
        int num = 0;
        for (String key : infoMap.keySet()) {
            int value = infoMap.get(key);
            num = recordMap.get(key);
            num = (int) Math.sqrt(num);
            value = value / num;
            maxPoints = Math.max(maxPoints, value);
        }
        return maxPoints;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // better!
    // 对每一个点，计算其他point在一个斜率的情况，concise solution!
    public int maxPoints2(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int n = points.length;
        int maxPoints = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            int duplicate = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int y = points[j][1] - points[i][1];
                int x = points[j][0] - points[i][0];
                StringBuilder sb = new StringBuilder();
                if (y == 0) {
                    if (x == 0) {
                        duplicate++;
                        continue;
                    } else {
                        sb.append(y);
                    }
                } else {
                    int gcd = Math.abs(gcd(x, y));
                    if (x > 0 ^ y > 0) {
                        sb.append("-");
                    }
                    sb.append(Math.abs(y / gcd)).append("/").append(Math.abs(x / gcd));
                }
                String key = sb.toString();
                int value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);
                max = Math.max(max, value);
            }
            maxPoints = Math.max(maxPoints, max + duplicate + 1);
        }
        return maxPoints;
    }


}
