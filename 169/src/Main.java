import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int v = map.get(nums[i]);
                map.put(nums[i], v + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int k = 0;
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                k = key;
                break;
            }
        }

        return k;
    }

    // Time:O(n) Space:O(1) fastest
    public int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0)
                major = nums[i];
            if (nums[i] == major)
                ++count;
            else
                --count;
        }
        return major;

    }
}
