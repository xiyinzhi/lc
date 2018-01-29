import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    }else if (n == 0){
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
}
