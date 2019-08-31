import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Main main = new Main();
        System.out.println(main.numberOfBoomerangs(points));
    }

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                if (map.containsKey(key)) {
                    int v = map.get(key);
                    map.put(key, v + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        int count = 0;
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > 1) {
                count += value * (value - 1);
            }
        }
        return count;
    }
}
