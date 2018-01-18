import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String[] strings = input.nextLine().split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(String.valueOf(strings[i]));
        }
        m.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public void moveZeroes(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - count; i++) {
            if (nums[i] == 0) {
                count += 1;
                for (int j = i; j < n - count; j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
            }
        }
        for (int i = n - count; i < n; i++) {
            nums[i] = 0;
        }
    }
}
