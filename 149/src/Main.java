import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] points = {{1, 1}, {1, 1}, {2, 2}, {2, 2}};
        System.out.println(main.maxPoints(points));
    }

    public class Data {
        private double x;
        private double y;

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Data)) return false;
            Data data = (Data) obj;
            return x == data.x && y == data.y;
        }

        @Override
        public int hashCode() {
            return (int) x * 137 ^ (int) y * 11731; //尽量用大奇数
        }


    }

    // 实在无法通过所有test case， 接下来改进思路：1.一开始就用hashmap去重 2.采用讨论区最大公约数方法
    public int maxPoints(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        if (points.length < 2) {
            return 1;
        }
        Map<Data, Integer> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (points[i][0] == points[j][0] && points[i][1] != points[j][1]) {
                    int temp = points[i][0];
                    if (map2.containsKey(temp)) {
                        int v = map2.get(temp);
                        map2.put(temp, v + 1);
                    } else {
                        map2.put(temp, 1);
                    }
                } else {
                    double a = 0.0;
                    double b = 0.0;
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        a = 1;
                        b = 0;
                    } else {
                        a = (double) (points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]);
                        b = points[i][1] - a * points[i][0];
                    }
                    Data data = new Data();
                    data.x = a;
                    data.y = b;
                    if (map.containsKey(data)) {
                        int v = map.get(data);
                        map.put(data, v + 1);
                    } else {
                        map.put(data, 1);
                    }
                }

            }
        }
        int maxCount = 0;
        for (Data data : map.keySet()) {
            int tempnum = map.get(data);
            if (tempnum > maxCount) {
                maxCount = tempnum;
            }
        }
        for (int tempkey : map2.keySet()) {
            int tempnum = map2.get(tempkey);
            if (tempnum > maxCount) {
                maxCount = tempnum;
            }
        }
        double temp = Math.sqrt(maxCount * 2);
        int res = (int) temp + 1;
        return res;
    }


}
