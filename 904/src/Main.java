import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(2)
    public int totalFruit(int[] tree) {
        int n = tree.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            map.put(tree[i], i);
            if (map.size() > 2) {
                count = i - start;
                maxLength = Math.max(count, maxLength);
                int minIndex = Collections.min(map.values());
                for (int key : map.keySet()) {
                    if (map.get(key) == minIndex) {
                        map.remove(key);
                        break;
                    }
                }
                start = minIndex + 1;
            }
        }
        maxLength = Math.max(n - start, maxLength);
        return maxLength;
    }
}
