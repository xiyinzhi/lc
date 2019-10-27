public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // dp
    // Time:O(m*n) Space:O(m*n) todo:空间可优化，rolling array
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n2 + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[n1][n2];
    }
}
