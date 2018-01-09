import java.util.Scanner;

/**
 * Created by xyz on 2017/12/18.
 */
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
        System.out.println("output:" + m.arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {
        int[] n = insertSort(nums);
        int count = 0;
        for (int i = 0; i < n.length / 2; i++) {
            count += n[2 * i];
        }
        return count;
    }

    private static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return arr;
    }




}
