import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(nlogn) Space:O(n)
    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        int[] begins = new int[26];
        int[] ends = new int[26];
        for (int i = 1; i <= len; i++) {
            int c = S.charAt(i) - 'a';
            if (begins[c] == 0) {
                begins[c] = i;
                ends[c] = i;
            } else {
                ends[c] = i;
            }
        }
        Arrays.sort(begins);
        Arrays.sort(ends);
        List<Integer> list = new ArrayList<>();
        int startIndex = 1;
        for (int i = 0; i < 25; i++) {
            if (begins[i] != 0) {
                if (ends[i] < begins[i + 1]) {
                    list.add(ends[i] - startIndex + 1);
                    startIndex = begins[i + 1];
                }
            }
        }
        list.add(ends[25] - startIndex + 1);
        return list;
    }
}
