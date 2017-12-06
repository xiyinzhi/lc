import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();

        Scanner input = new Scanner(System.in);
        System.out.println("Input:");
        String str = input.nextLine();
        System.out.println("Target:");
        int target = input.nextInt();

        String[] strings = str.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        int[] output = m.twoSum(nums, target);
        System.out.println("Output:[" + output[0] + ", " + output[1] + "]");
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] output = new int[2];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    return output;
                }
            }
        }
        throw new IllegalArgumentException("wrong input");
    }

}
