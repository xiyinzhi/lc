public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // dp 有点难
    // Time:O(n) Space:O(n), discuss has space O(1) solution, 但还没看懂
    // key: swap[i] 保持1-i increasing & swap A[i],B[i]
    public int minSwap(int[] A, int[] B) {
        int count = 0;
        if (A == null || B == null || A.length < 2 || B.length < 2 || A.length != B.length) {
            return count;
        }
        int n = A.length;
        int[] swap = new int[n];
        int[] notSwap = new int[n];
        for (int i = 1; i < n; i++) {
            notSwap[i] = swap[i] = n;
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                notSwap[i] = notSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (B[i] > A[i - 1] && A[i] > B[i - 1]) {
                notSwap[i] = Math.min(swap[i - 1], notSwap[i]);
                swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
            }
        }
        return Math.min(swap[n - 1], notSwap[n - 1]);
    }
}
