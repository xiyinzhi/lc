import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                break;
            } else {
                set.add(nums[i]);
            }
        }
        if (set.size() < n) {
            return true;
        } else {
            return false;
        }
    }
}
