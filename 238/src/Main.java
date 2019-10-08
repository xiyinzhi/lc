public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 2, 3, 4};
        System.out.println(main.productExceptSelf(nums));
    }

    // so many edge cases
    // Time:O(n) Space:O(1), but uses divisions, not very good
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        long maxProduct = 1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (!flag) {
                    flag = true;
                    continue;
                } else {
                    flag = false;
                    maxProduct = 0;
                    break;
                }
            }
            maxProduct *= (long) nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (flag) {
                if (nums[i] == 0) {
                    nums[i] = (int) maxProduct;
                } else {
                    nums[i] = 0;
                }
            } else {
                if (maxProduct == 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = (int) (maxProduct / nums[i]);
                }

            }
        }
        return nums;
    }

    // Time:O(n) Space:O(1), without division
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int p = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= p;
            p *= nums[i];
        }
        return res;
    }
}
