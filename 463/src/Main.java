public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(m*n) Space:O(m*n)
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int p = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        p++;
                    }
                    if (i == m - 1 || grid[i + 1][j] == 0) {
                        p++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        p++;
                    }
                    if (j == n - 1 || grid[i][j + 1] == 0) {
                        p++;
                    }
                }
            }
        }
        return p;
    }
}
