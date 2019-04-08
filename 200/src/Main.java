public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(main.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFSMarking(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || i == n || j < 0 || j == m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        DFSMarking(grid, i - 1, j, n, m);
        DFSMarking(grid, i + 1, j, n, m);
        DFSMarking(grid, i, j - 1, n, m);
        DFSMarking(grid, i, j + 1, n, m);
    }
}

