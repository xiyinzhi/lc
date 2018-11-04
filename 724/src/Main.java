public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (sum - leftSum - nums[i] == leftSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return -1;
    }
}
