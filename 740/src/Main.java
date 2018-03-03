import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Input:");
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(",");
        int n = strings.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("Output: " + m.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = nums[n - 1];

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        //create a map <num, count>
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                count = nums[i];
            } else if (nums[i] != nums[i - 1]) {
                map.put(nums[i - 1], count);
                count = nums[i];
            } else {
                count += nums[i];
            }
        }
        map.put(nums[n - 1], count);
        for (int i = 1; i < max; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
        }
        int len = map.size();

        int[] dp = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            if (i == 1) {
                dp[i] = map.get(i);
            } else if (i == 2) {
                if (map.get(i) > dp[i - 1]) {
                    dp[i] = map.get(i);
                } else {
                    dp[i] = dp[i - 1];
                }
            } else if (dp[i - 1] > dp[i - 2] + map.get(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 2] + map.get(i);
            }
        }

        return dp[len];
    }
}
