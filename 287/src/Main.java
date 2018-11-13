import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(nlogn) Space:O(1)
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    // Time:O(n) Space:O(n)
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (freq[i] > 1) {
                return i;
            }
        }
        return 0;
    }


}
