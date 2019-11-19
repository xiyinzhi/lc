public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * DP, Time:O(n^2) Space:O(n)
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
