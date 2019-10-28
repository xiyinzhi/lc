import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] nums = {};
        int k = 2;
        System.out.println(checkSubarraySum(nums, k));
    }

    // Time:O(n) Space:O(k)
    // 这题其实和974是一样的？比974多一点条件
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0 && i < n - 1 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        k = Math.abs(k);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (map.containsKey(reminder)) {
                if (i - map.get(reminder) > 1) {
                    return true;
                }
            } else {
                map.put(reminder, i);
            }
        }
        return false;
    }
}
