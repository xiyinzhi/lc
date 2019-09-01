import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        Main main = new Main();
        System.out.println(main.numberOfBoomerangs(points));
    }

    /** 注意map有几种可以简化的写法，可以处理反复new的情况等 */
    // Time:O(n^2) Space:O(n)
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    int key = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    if (map.containsKey(key)) {
                        int v = map.get(key);
                        map.put(key, v + 1);
                    } else {
                        map.put(key, 1);
                    }
                    /**
                     * int v = map.getOrDefault(key, 0);
                     * 可以处理key不存在的情况
                     * 然后直接map.put(key, v + 1);
                     * */
                }
            }
            for (int key : map.keySet()) {
                int value = map.get(key);
                if (value > 1) {
                    count += value * (value - 1);
                }
            }
            map.clear();
        }
        return count;
    }
}
