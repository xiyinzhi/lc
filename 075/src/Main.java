public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = {2, 0, 2, 1, 1, 0};
        m.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                r++;
            } else if (nums[i] == 1) {
                w++;
            } else {
                b++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < r) {
                nums[i] = 0;
            } else if (i < r + w) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
