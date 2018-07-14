import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n*k) Space:O(1)
    // Time Limit Exceed
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - k); j < Math.min(n, i + k + 1); j++) {
                if (nums[i] == nums[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time:O(n) Space:O(n)
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

    // Time:O(n) Space:O(n) beat 100%
    // HashMap.put()方法返回原value！
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        if (nums.length > 1000) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            Integer ord = map.put(nums[i], i);
            if (ord != null && i - ord <= k) {
                return true;
            }
        }

        return false;
    }
}
