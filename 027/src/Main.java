public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[p1++] = nums[i];
            }
        }
        return p1;
    }
}
