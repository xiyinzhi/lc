public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n*m) Space:O(1)
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    area = DFSMarking(grid, n, m, i, j, area);
                    maxArea = Math.max(area, maxArea);
                    area = 0;
                }
            }
        }
        return maxArea;
    }

    public int DFSMarking(int[][] grid, int n, int m, int i, int j, int area) {
        if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || grid[i][j] == 0) {
        } else {
            area++;
            grid[i][j] = 0;
            area = DFSMarking(grid, n, m, i - 1, j, area);
            area = DFSMarking(grid, n, m, i + 1, j, area);
            area = DFSMarking(grid, n, m, i, j - 1, area);
            area = DFSMarking(grid, n, m, i, j + 1, area);
        }
        return area;
    }
}
