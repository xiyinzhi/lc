import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(nlogn) Space:O(1)
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int dif = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = nums[i + 1] - nums[i];
            if (temp > dif) {
                dif = temp;
            }
        }
        return dif;
    }
}
