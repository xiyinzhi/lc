import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = {2, 3, 3, 2, 2, 2, 1, 1};
        m.wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    // sorting
    // Time:O(nlogn) Space:O(n)
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return;
        }
        Arrays.sort(nums);

        int[] res = new int[n];
        if (n % 2 == 1) {
            for (int i = 0; i < n / 2; i++) {
                res[2 * i] = nums[i];
                res[2 * i + 1] = nums[n / 2 + i + 1];
            }
            res[n - 1] = nums[n / 2];
        } else {
            for (int i = 0; i < n / 2; i++) {
                res[2 * i] = nums[i];
                res[2 * i + 1] = nums[n / 2 + i];
            }
        }

        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }

        // move 2 nums each iterator
        if (n > 2) {
            for (int k = 1; k < n / 2; k++) {
                if (res[2 * k - 1] <= res[2 * k]) {
                    for (int i = 0; i < n; i++) {
                        if (i <= n - 2 * k - 1) {
                            nums[i] = res[i + 2 * k];
                        } else {
                            nums[i] = res[i - n + 2 * k];
                        }
                    }
                }
            }
        }
    }
}
