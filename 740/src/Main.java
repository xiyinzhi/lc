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
        System.out.println("Output: " + m.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);

    }
}
