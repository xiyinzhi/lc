public class Main {

    public static void main(String[] args) {
        int[] A = {1};
        System.out.println(sortedSquares(A));
    }

    // 2 pointers
    // Time:O(n) Space:O(n)
    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int p1 = 0;
        int p2 = n - 1;
        for (int i = 0; i < n; i++) {
            if (A[i] >= 0) {
                p2 = i;
                p1 = i - 1;
                break;
            }
        }
        int i = 0;
        // be careful, p1 cannot be equal to p2
        if (p2 == p1) {
            p1 = p2 - 1;
        }
        while (p1 >= 0 && p2 <= n - 1) {
            if (Math.abs(A[p2]) > Math.abs(A[p1])) {
                res[i++] = A[p1] * A[p1];
                p1--;
            } else {
                res[i++] = A[p2] * A[p2];
                p2++;
            }
        }
        while (p1 < 0 && p2 <= n - 1) {
            res[i++] = A[p2] * A[p2];
            p2++;
        }
        while (p2 > n - 1 && p1 >= 0) {
            res[i++] = A[p1] * A[p1];
            p1--;
        }
        return res;
    }
}
