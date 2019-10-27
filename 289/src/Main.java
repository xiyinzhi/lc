public class Main {

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        gameOfLife(board);
    }

    // Time:O(n*m) Space:O(1) in-place! excellent solution!
    public static void gameOfLife(int[][] board) {
        if (board == null) return;
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                for (int k1 = Math.max(0, i - 1); k1 <= Math.min(n - 1, i + 1); k1++) {
                    for (int k2 = Math.max(0, j - 1); k2 <= Math.min(m - 1, j + 1); k2++) {
                        if ((board[k1][k2] & 1) == 1) {
                            count++;
                        }
                    }
                }
                count -= board[i][j];
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (count <= 3 && count >= 2) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] /= 2;
            }
        }
    }
}
