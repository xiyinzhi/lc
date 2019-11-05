import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        if (equations == null || equations.size() == 0 || values == null || values.length == 0 || equations.size() != values.length || queries == null || queries.size() == 0) {
            return null;
        }

        int size = equations.size();
        /** 建立map的时候需要把反过来的关系也存上*/
        for (int i = 0; i < size; i++) {
            List<String> temp = equations.get(i);
            if (map.containsKey(temp.get(0))) {
                Map<String, Double> value = map.get(temp.get(0));
                value.put(temp.get(1), values[i]);
            } else {
                Map<String, Double> value = new HashMap<>();
                value.put(temp.get(1), values[i]);
                map.put(temp.get(0), value);
            }
            if (map.containsKey(temp.get(1))) {
                Map<String, Double> value = map.get(temp.get(1));
                value.put(temp.get(0), 1 / values[i]);
            } else {
                Map<String, Double> value = new HashMap<>();
                value.put(temp.get(0), 1 / values[i]);
                map.put(temp.get(1), value);
            }
        }

        int m = queries.size();
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            List<String> temp = queries.get(i);
            String a = temp.get(0);
            String b = temp.get(1);
            res[i] = helper(map, new HashSet<>(), 1, a, b);
        }
        return res;
    }

    // dfs
    public double helper(Map<String, Map<String, Double>> map, Set<String> visited, double res, String start, String end) {
        if (!map.containsKey(start)) {
            return -1;
        }
        if (start.equals(end)) {
            return 1;
        }
        if (map.get(start).containsKey(end)) {
            return res * map.get(start).get(end);
        }
        double result = -1;
        visited.add(start);
        for (String key : map.get(start).keySet()) {
            if (!visited.contains(key)) {
                result = helper(map, visited, res * map.get(start).get(key), key, end);
                if (result != -1) {
                    return result;
                }
            }
        }
        return result;
    }

}
