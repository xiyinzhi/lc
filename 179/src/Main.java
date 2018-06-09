import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
//        int[] nums = {3, 30, 34, 5, 9};
        int[] nums = {121, 12};
        System.out.println(m.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings);
        int k = 0;
        int[] ks = new int[10];
        for (int i = 0; i < n - 1; i++) {
            if (!strings[i].substring(0, 1).equals(strings[i + 1].substring(0, 1))) {
                ks[k] = i + 1;
                k++;
            }
        }
        ks[k++] = n;
        for (int j = 0; j < k; j++) {
            int start = j == 0 ? 0 : ks[j - 1];
            int end = ks[j]; //exclusive
            for (int i = start; i < end - 1; i++) {
                for (int l = i + 1; l < end; l++) {
                    String str1 = strings[i] + strings[l];
                    String str2 = strings[l] + strings[i];
                    if (str1.compareTo(str2) > 0) {
                        String temp = strings[l];
                        strings[l] = strings[i];
                        strings[i] = temp;
                    }
                }
            }

        }
        String s = new String();
        for (int i = 0; i < n; i++) {
            s += strings[n - i - 1];
        }
        int l = s.length();
        while (s.startsWith("0")) {
            if (l != 1) {
                s = s.substring(1, l--);
            } else {
                break;
            }
        }
        return s;
    }
}
