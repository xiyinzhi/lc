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
        int[] maxMoney = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxMoney[i] = nums[i];
            } else if (i == 1) {
                maxMoney[i] = Math.max(nums[1], nums[0]);
            } else {
                maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
            }
        }
        return maxMoney[n - 1];
    }
}
