public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * basic DP
     * Time:O(m*n) Space:O(m*n)
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    if (i >= 1 && obstacleGrid[i - 1][j] != 1) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j >= 1 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * optimized DP - no extra space
     * Time:O(m*n) Space:O(1)
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] != 1) {
                    if (i >= 1) {
                        obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                    }
                    if (j >= 1) {
                        obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                    }
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[n - 1][m - 1];
    }
}
