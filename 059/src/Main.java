public class Main {

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int i = 0;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        while (true) {
            for (int j = left; i <= right; j++) {
                matrix[top][j] = ++i;
            }
            top++;
            if (i == n * n) {
                break;
            }

            for (int j = top; j <= bottom; j++) {
                matrix[j][right] = ++i;
            }
            right--;
            if (i == n * n) {
                break;
            }

            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = ++i;
            }
            bottom--;
            if (i == n * n) {
                break;
            }

            for (int j = bottom; j >= top; j--) {
                matrix[j][left] = ++i;
            }
            left++;
            if (i == n * n) {
                break;
            }
        }
        return matrix;
    }
}
