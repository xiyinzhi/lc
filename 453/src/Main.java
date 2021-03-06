import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Input:");
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(",");
        int n = strings.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("Output: " + m.minMoves(nums));
    }

    //brute force Time:O(n^2*k) k is max-min at first. Space:O(1) It is [Time Limit Exceeded]
    public int minMoves(int[] nums) {
        int count = 0;
        int minMark = findMin(nums);
        int maxMark = findMax(nums);
        while (nums[minMark] != nums[maxMark]) {
            for (int i = 0; i < nums.length; i++) {
                if (i != maxMark) {
                    nums[i]++;
                }
            }
            minMark = findMin(nums);
            maxMark = findMax(nums);
            count++;
        }
        return count;
    }

    public int findMin(int[] nums) {
        int minMark = 0;
        int min = nums[minMark];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                minMark = i;
                min = nums[i];
            }
        }
        return minMark;
    }

    public int findMax(int[] nums) {
        int maxMark = 0;
        int max = nums[maxMark];
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                maxMark = i;
                max = nums[i];
            }
        }
        return maxMark;
    }

    /**
     * Math! so easy!
     * "incrementing n - 1 elements by 1" is equal to "minus 1 of the max number"
     * so we should delete 1 a time until all numbers equals to min
     * Time:O(n)
     * Apace:O(1)
     */
    public int minMoves2(int[] nums) {
        int count = 0;
        int n = nums.length;
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            count += nums[i] - min;
        }
        return count;
    }
}
