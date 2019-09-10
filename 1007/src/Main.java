public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] A = {2, 1, 2, 4, 2, 2};
        int[] B = {5, 2, 6, 2, 3, 2};
        System.out.println(main.minDominoRotations2(A, B));
    }

    // time:O(n) Space:O(n)
    // 2-loops
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        if (n != B.length || n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int[] counts = new int[6];
        int max = 0;
        int aTimes = 0;
        int bTimes = 0;
        for (int i = 0; i < n; i++) {
            counts[A[i] - 1]++;
            counts[B[i] - 1]++;
        }
        for (int i = 0; i < 6; i++) {
            if (counts[max] <= counts[i]) {
                max = i;
            }
        }
        max++;
        for (int i = 0; i < n; i++) {
            if (A[i] == max) {
                aTimes++;
            }
            if (B[i] == max) {
                bTimes++;
            }
            if (A[i] != max && B[i] != max) {
                return -1;
            }
        }
        return Math.max(n - aTimes, n - bTimes);
    }


    // time:O(n) Space:O(n)
    // 1-loops
    public int minDominoRotations2(int[] A, int[] B) {
        int n = A.length;
        if (n != B.length || n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int[] aCount = new int[6];
        int[] bCount = new int[6];
        int[] same = new int[6];
        for (int i = 0; i < n; i++) {
            aCount[A[i] - 1]++;
            bCount[B[i] - 1]++;
            if (A[i] == B[i]) {
                same[A[i] - 1]++;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (aCount[i] + bCount[i] - same[i] >= n) {
                return Math.min(n - aCount[i], n - bCount[i]);
            }
        }
        return -1;
    }
}
