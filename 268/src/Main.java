public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(1)
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += i - nums[i];
        }
        return n + sum;
    }
}
