public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 妙啊
    // https://leetcode.com/problems/n-repeated-element-in-size-2n-array/discuss/208563/JavaC%2B%2BPython-O(1)-Solution

    /**
     * Time:O(N) Space:O(1)
     */
    public int repeatedNTimes(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1]) {
                return A[i];
            } else if (i + 2 < n && A[i] == A[i + 2]) {
                return A[i];
            } else if (i + 3 < n && A[i] == A[i + 3]) {
                return A[i];
            }
        }
        return -1;
    }

    // 绝妙的想法
    public int repeatedNTimes2(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 2; i++) {
            if (A[i] == A[i + 1] || A[i] == A[i + 2]) {
                return A[i];
            }
        }
        return A[n - 1];
    }
}
