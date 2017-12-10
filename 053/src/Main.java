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
        System.out.println("output2:" + m.maxSubArray2(nums));
        System.out.println("output3:" + m.maxSubArray3(nums));
    }

    //brute force o(n^3)
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

    //greedy o(n)
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    //dp o(n)
    public int maxSubArray3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subArray ending with nums[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
