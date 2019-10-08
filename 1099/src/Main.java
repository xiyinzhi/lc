import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(nlogn) Space:O(1)
    // Arrays.sort+binary search, beat 100%
    public int twoSumLessThanK(int[] A, int K) {
        int n = A.length;
        Arrays.sort(A);
        int lastIndex = n - 1;
        int maxSum = -1;
        for (int i = 0; i < n; i++) {
            if (i < lastIndex) {
                int index = helper(A, K - A[i], i, lastIndex);
                if (index > i) {
                    lastIndex = index;
                    maxSum = Math.max(maxSum, A[index] + A[i]);
                }
            } else {
                break;
            }
        }
        return maxSum;
    }

    // binary search
    public int helper(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid - 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
