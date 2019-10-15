import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * use the method in "word search", Time:O(k*m*n*(4^s)) Space:O(m*n) 因为m*n>s
     */
    public List<String> findWords(char[][] board, String[] words) {
        int k = words.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (exist(board, words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }

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

    public List<String> findWords2(char[][] board, String[] words) {

    }
}
