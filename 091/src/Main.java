public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * DP
     * Time:O(n) Space:O(n)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= 2 && isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
            if (i >= 1 && isValid(s.substring(i - 1, i))) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n];
    }

    public boolean isValid(String s) {
        int num = Integer.parseInt(s);
        int n = s.length();
        if (num >= 1 && num <= 9 && n == 1) {
            return true;
        } else if (num > 9 && num <= 26 && n == 2) {
            return true;
        } else {
            return false;
        }
    }
}
