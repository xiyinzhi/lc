import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String str = input.nextLine();
        String[] strings = str.split(",");
        int n = strings.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("output:" + m.maxSubArray(nums));
    }

    //bruce forte o(n^3)
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                max = Math.max(sum(nums, i, j), max);
            }
        }
        return max;
    }

    public int sum(int[] nums, int offset, int count) {
        int n = nums.length;
        int sum = 0;
        for (int i = offset; i <= count; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
