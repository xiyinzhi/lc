public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // binary search
    // Time:O(N) wost case: traverse
    // Space:O(1)
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
                // 跟LC33比，关键是处理low!=mid但nums[low]==nums[mid]的情况，这种情况无法二分，worst case必须遍历
            } else if (nums[mid] > nums[low] || (mid == low && nums[mid] == nums[low])) {
                if (target < nums[mid] && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < nums[low]) {
                if (nums[high] >= target && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }
}
