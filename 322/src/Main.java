import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    // dp
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (i == 408) {
                System.out.println();
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                int target = i - coins[j];
                if (target >= 0 && dp[target] >= 0) {
                    min = Math.min(min, dp[target]);
                } else if (target < 0) {
                    break;
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
