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
        System.out.println("Output: " + m.rob(nums));
    }

    //DP Time:O(n) Space:O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] maxMoney = new int[n];
        int res1, res2;
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                maxMoney[i] = nums[i];
            } else if (i == 1) {
                maxMoney[i] = Math.max(nums[1], nums[0]);
            } else {
                maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
            }
        }
        res1 = maxMoney[n - 2];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                maxMoney[i] = nums[i];
            } else if (i == 2) {
                maxMoney[i] = Math.max(nums[2], nums[1]);
            } else {
                maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
            }
        }
        res2 = maxMoney[n - 1];
        return Math.max(res1, res2);
    }
}
