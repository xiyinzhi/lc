import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(logn) Space:O(1)
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
        if (low > 0 && target < nums[low - 1]) {
            return high;
        } else {
            return low;
        }
    }



}
