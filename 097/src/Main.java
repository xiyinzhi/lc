public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // dp
    // Time:O(m+n) Space:O(m*n)
    // 应该可以用滚动数组优化
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if (n3 != n1 + n2) {
            return false;
        }
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        for (int i = 0; i < n1 + 1; i++) {
            for (int j = 0; j < n2 + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else {
                    if (((j == 0 || i > 0) && dp[i - 1][j]) && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = true;
                    }
                    if (((i == 0 || j > 0) && dp[i][j - 1]) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[n1][n2];
    }
}
