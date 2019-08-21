import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            int count = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    set.add(board[i][j]);
                    count++;
                }
            }
            if (count != set.size()) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            int count = 0;
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    set.add(board[j][i]);
                    count++;
                }
            }
            if (count != set.size()) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                HashSet<Character> set = new HashSet<>();
                int count = 0;
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (board[3 * i + ii][3 * j + jj] != '.') {
                            set.add(board[3 * i + ii][3 * j + jj]);
                            count++;
                        }
                    }
                }
                if (count != set.size()) {
                    return false;
                }
            }
        }
        return true;
    }
}
