public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // brilliant idea
    // 你的小脑瓜怎么想不出来呢。
    // Time:O(m+n) Space:O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (row < n && col >= 0) {
            int currNum = matrix[row][col];
            if (currNum == target) {
                return true;
            } else if (target > currNum) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
