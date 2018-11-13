public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(1)
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        int n = nums.length;
        int mark = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[p2]) {
                mark = 0;
            }
            if (nums[i] != nums[p2] || mark < 2) {
                nums[++p1] = nums[i];
            }
            mark++;
            p2++;
        }
        return p1 + 1;
    }
}
