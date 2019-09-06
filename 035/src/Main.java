public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low >= 0 && target < nums[low]) {
            return high;
        } else {
            return low;
        }
    }
}
