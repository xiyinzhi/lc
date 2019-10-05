public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(logN) Space:O(1)
    // 条件还是画图可靠
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 && nums[mid] < nums[mid + 1]) || (mid == n - 1 && nums[mid] < nums[mid - 1]) || (mid != 0 && mid != n - 1 && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if (nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
