public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int p1 = 1;
        int m = nums[0];
        for (int i = 0; i < n; i++) {
            if (m != nums[i]) {
                m = nums[i];
                nums[p1++] = nums[i];
            }
        }
        return p1;
    }

}
