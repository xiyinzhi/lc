import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
//        int[][] grid = {{0, 1}, {0, 1}, {0, 1}, {1, 1}, {0, 0}, {0, 1}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {1, 0}, {1, 0}, {0, 0}, {0, 0}, {1, 1}, {0, 0}};
        System.out.println(m.minTotalDistance3(grid));
    }

    // Time:O(m^2*n^2) Space:O(1)
    public int minTotalDistance(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int minDistance = 0;
        for (int r = 0; r < n; r++) {
            for (int s = 0; s < m; s++) {
                int temp = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == 1) {
                            temp += Math.abs(r - i) + Math.abs(s - j);
                        }
                    }
                }
                if (r == 0 && s == 0) {
                    minDistance = temp;
                } else {
                    minDistance = Math.min(temp, minDistance);
                }
            }
        }
        return minDistance;
    }

    // Time:O(m^2*n^2) Space:O(m*n) worse time
    public int minTotalDistance2(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int[][] ints = new int[2][n * m];
        int l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ints[0][l] = i;
                    ints[1][l++] = j;
                }
            }
        }

        int minDistance = 0;
        for (int r = 0; r < n; r++) {
            for (int s = 0; s < m; s++) {
                int temp = 0;
                for (int j = 0; j < l; j++) {
                    temp += Math.abs(r - ints[0][j]) + Math.abs(s - ints[1][j]);
                }
                if (r == 0 && s == 0) {
                    minDistance = temp;
                } else {
                    minDistance = Math.min(temp, minDistance);
                }
            }
        }
        return minDistance;
    }

    // Time:O(m*n) Space:O(m*n)
    public int minTotalDistance3(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int minDistance = 0;

        int[][] ints = new int[2][n * m];
        int l = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ints[0][l] = i;
                    ints[1][l++] = j;
                }
            }
        }
        Arrays.sort(ints[0], 0, l);
        Arrays.sort(ints[1], 0, l);
        int[] x = new int[2];
        int[] y = new int[2];
        x[0] = ints[0][(l - 1) / 2];
        x[1] = x[0] + 1;
        y[0] = ints[1][(l - 1) / 2];
        y[1] = y[0] + 1;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int temp = 0;
                for (int r = 0; r < n; r++) {
                    for (int s = 0; s < m; s++) {
                        if (grid[r][s] == 1) {
                            temp += Math.abs(r - x[i]) + Math.abs(s - y[j]);
                        }
                    }
                }
                if (i == 0 && j == 0) {
                    minDistance = temp;
                } else {
                    minDistance = Math.min(temp, minDistance);
                }
            }
        }
        return minDistance;
    }
}
