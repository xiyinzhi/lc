import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // sorting
    // Time:O(nlogn) Space:O(1)
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        Arrays.sort(nums);
        for (int i = 0; i < (n - 1) / 2; i++) {
            int temp = nums[2 * i + 2];
            nums[2 * i + 2] = nums[2 * i + 1];
            nums[2 * i + 1] = temp;
        }
    }

    // without sorting
    // Time:O(n) Space:O(1)
    // can use swap function
    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                if (nums[i - 1] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            } else {
                if (nums[i - 1] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
        }
    }

}
