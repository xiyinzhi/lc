public class Main {

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Main main = new Main();
        System.out.println(main.exist(board, word));
    }

    // DFS
    // Time:O(m*n*(4^k)) Space:O(m*n) k:length of String

    // todo: can save space to O(1) using char^256? see discuss
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0 || word == null) {
            return false;
        }
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int position, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        int len = word.length();
        if (position == len) {
            return true;
        }

        if (word.charAt(position) == board[i][j] && !visited[i][j]) {
            visited[i][j] = true;
            if (position + 1 == len) {
                return true;
            } else {
                if (search(board, word, position + 1, i - 1, j)
                        || search(board, word, position + 1, i + 1, j)
                        || search(board, word, position + 1, i, j - 1)
                        || search(board, word, position + 1, i, j + 1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;

    }
}
