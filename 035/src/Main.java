public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 优化前, binary search
    // Time:O(logn) Space:O(1)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
                if (low > high) {
                    // mid = low
                    return mid;
                }
            } else {
                low = mid + 1;
                if (low > high) {
                    return low;
                }
            }
        }
        return -1;
    }

    /**
     * 其实返回全是low这个需要思考一下，简约！
     */
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
