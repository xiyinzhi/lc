public class Main {

    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * DP
     * dp[i]: LIS of[0,i], including nums[i]
     * Time:O(n^2) Space:O(n)
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            boolean isFind = false;
            for (int j = i - 1; j > 0; j--) {
                if (nums[i - 1] > nums[j - 1] && dp[i] < dp[j] + 1) {
                    isFind = true;
                    dp[i] = dp[j] + 1;
                }
            }
            if (!isFind) {
                dp[i] = 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
