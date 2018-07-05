import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // very similar as 2sum
    // avoid duplicate results
    // Time:O(n) Space:O(n)
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int v = map.get(num);
                map.put(num, v + 1);
            } else {
                map.put(num, 1);
            }
        }
        int count = 0;
        for (int key : map.keySet()) {
            int k2 = k + key;
            if (map.containsKey(k2)) {
                if (k2 < key || (k2 == key && map.get(k2) > 1)) {
                    count++;
                }
            }
        }
        for (int key : map.keySet()) {
            int k2 = key - k;
            if (map.containsKey(k2)) {
                if (k2 < key || (k2 == key && map.get(k2) > 1 && k!= 0)) {
                    count++;
                }
            }
        }
        return count;
    }
}
