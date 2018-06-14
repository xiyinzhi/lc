import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // sorting
    // Time:O(nlogn) Space:O(1)
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int dif = 0;
        for (int i = 0; i < n - 1; i++) {
            int temp = nums[i + 1] - nums[i];
            if (temp > dif) {
                dif = temp;
            }
        }
        return dif;
    }

    // without sorting
    // Time:O(n) Space:O(n)
    public int maximumGap2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        if (max == min || n == 2) {
            return max - min;
        }

        // core thought: "pigeon hole principle", put n objects in n-1 buckets, at least one bucket has 2 objects.
        // So the max gap must be in different bucket("adjacent").
        int[] mins = new int[n];
        int[] maxs = new int[n];
        Arrays.fill(mins, MAX_VALUE);
        Arrays.fill(maxs, -1);

        for (int i = 0; i < n; i++) {
            double temp = (double) (max - min) / (n - 1);
            int index = (int) ((nums[i] - min) / temp);
            mins[index] = Math.min(mins[index], nums[i]);
            maxs[index] = Math.max(maxs[index], nums[i]);
        }

        int maxGap = (max - min) / (n - 1);
        int tempMin = -1, tempMax = -1;
        for (int i = 0; i < n; i++) {
            if (maxs[i] == -1) {
                continue;
            } else {
                tempMin = mins[i];
                if (tempMax != -1) {
                    tempMin = mins[i];
                    maxGap = Math.max(maxGap, tempMin - tempMax);
                }
                tempMax = maxs[i];
            }
        }
        return maxGap;
    }
}
