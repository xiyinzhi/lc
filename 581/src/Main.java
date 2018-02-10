import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Input:");
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(",");
        int n = strings.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("Output: " + m.findUnsortedSubarray2(nums));
    }

    /**
     * use sorting
     * Time:O(nlogn) Space:O(n)
     * IMPORTANT: can not just use
     * int[] sortedNums = nums;
     * It makes both arrays just point to the same address
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sortedNums = new int[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);
        int count = 0;

        for (int i = 0; i < n && nums[i] == sortedNums[i]; i++) {
            count++;
        }
        for (int i = 0; i < n && nums[n - i - 1] == sortedNums[n - i - 1]; i++) {
            count++;
        }
        return Math.max(0, n - count);
    }

    /**
     * do not use sorting
     * Time:O(n) Space:O(1)
     */
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int count = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(nums[i], min);
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                max = Math.max(nums[i - 1], max);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > min) {
                count += i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < max) {
                count += n - i - 1;
                break;
            }
        }
        return count == 0 && max <= min ? 0 : n - count;
    }
}
