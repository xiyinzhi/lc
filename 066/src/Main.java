import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        char[] chars = input.nextLine().toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        System.out.println("output:" + m.plusOne(nums));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (digits[len - i - 1] == 9) {
                digits[len - i - 1] = 0;
            } else {
                digits[len - i - 1] += 1;
                return digits;
            }
        }
        int[] nums = new int[len + 1];
        nums[0] = 1;
        //can be better
//        for (int i = 0; i <= len; i++) {
//            if (i == 0) {
//                nums[i] = 1;
//            } else {
//                nums[i] = digits[i - 1];
//            }
//        }
        return nums;
    }
}
