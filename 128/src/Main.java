import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        Main main = new Main();
        System.out.println(main.longestConsecutive2(nums));
    }

    // Exception in thread "main" java.lang.NegativeArraySizeException
    // Time:O(max(max-min,n)) Space:O(n)
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[] a = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            a[nums[i] - min]++;
        }
        int count = 1;
        int maxCount = 0;
        for (int i = 0; i < max - min; i++) {
            if (a[i + 1] != 0) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return maxCount;
    }

    // Time:O(n) Space:O(n)
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        if (n < 0) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int count = 1;
        int maxCount = 0;
        while (set.size() != 0) {
            Iterator<Integer> it = set.iterator();
            if (it.hasNext()) {
                int i = it.next();
                int temp = i;
                set.remove(i);
                while (set.contains(++temp)) {
                    count++;
                    set.remove(temp);
                }
                temp = i;
                while (set.contains(--temp)) {
                    count++;
                    set.remove(temp);
                }
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        return maxCount;
    }
}
