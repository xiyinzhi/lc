public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // use the idea of 'game of life'
    // bit manipulation
    // Time:O(m*n) Space:O(1)
    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int number = 0;
                for (int k = Math.max(0, i - 1); k <= Math.min(i + 1, n - 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(j + 1, m - 1); l++) {
                        sum += M[k][l] & 255;
                        number++;
                    }
                }
                int ave = sum / number;
                M[i][j] += ave * 256;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                M[i][j] >>= 8;
            }
        }
        return M;
    }
}
