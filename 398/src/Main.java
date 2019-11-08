import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    class Solution {
        Random random = new Random();
        private int size;
        private int[] nums;

        public Solution(int[] nums) {
            size = nums.length;
            this.nums = nums;
        }

        public int pick(int target) {
            int i = random.nextInt(size);
            while (nums[i] != target) {
                i = random.nextInt(size);
            }
            return i;
        }
    }
}
