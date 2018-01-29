import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        String[] strings2 = input.nextLine().split(",");
        int[] nums2 = new int[strings2.length];
        for (int i = 0; i < strings2.length; i++) {
            nums2[i] = Integer.parseInt(strings2[i]);
        }
        System.out.println("Output: " + m.intersection(nums, nums2));
    }

    //O(n^2)
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> newNums = new ArrayList();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) {
                    int n = newNums.size();
                    if (n > 0 && newNums.get(n - 1) != nums1[i]) {
                        newNums.add(nums1[i]);
                        break;
                    } else if (n == 0) {
                        newNums.add(nums1[i]);
                        break;
                    }
                }
            }
        }
        int[] answers = new int[newNums.size()];
        for (int i = 0; i < newNums.size(); i++) {
            answers[i] = newNums.get(i);
        }
        return answers;
    }

    //O(nlogn) binary search
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1, nums2[i]) && !set.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            res[i] = num;
            i++;
        }
        return res;
    }

    public boolean binarySearch(int[] nums, int target) {
        int n = nums.length;
        if (n == 1 && nums[0] == target) {
            return true;
        }
        int low = 0;
        int high = n - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    //O(n) use set.contain()
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]) && !intersect.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int i = 0;
        int[] res = new int[intersect.size()];
        for (Integer num : intersect) {
            res[i] = num;
            i++;
        }
        return res;
    }
}
