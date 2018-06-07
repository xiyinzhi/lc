import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        System.out.println("Output: " + m.intersect(nums, nums2));
    }

    // use HashMap
    // Time:O(m+n) Space:O(m+n)
    // but if consider Map.containsKey() Time should be O(n^2)
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                int v = map1.get(num);
                map1.remove(num);
                map1.put(num, v + 1);
            } else {
                map1.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map2.containsKey(num)) {
                int v = map2.get(num);
                map2.remove(num);
                map2.put(num, v + 1);
            } else {
                map2.put(num, 1);
            }
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                for (int v = 0; v < Math.min(map1.get(key), map2.get(key)); v++) {
                    res[k++] = key;
                }
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }

    // simple Sorting Time:O(nlogn) Space:O(min(m+n))
    // fastest, beat 100%, interesting
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int k = 0;

        int[] res = new int[Math.min(nums1.length, nums2.length)];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res[k] = nums1[i];
                k++;
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }

}
