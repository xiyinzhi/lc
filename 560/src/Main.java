import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 1, 1};
        System.out.println(main.subarraySum2(nums, 2));
    }

    // Time:O(n^2) Space:O(n)
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                if (sums[j] - sums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Time:O(n) Space:O(n)
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int v = map.getOrDefault(sum - k, 0);
            count += v;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
