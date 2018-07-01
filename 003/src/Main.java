import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.lengthOfLongestSubstring("tmmzuxt"));
    }

    // Time:O(n) Space:O(n)
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < n) {
            if (set.contains(ch[j])) {
                maxLen = Math.max(maxLen, j - i);
                i = s.indexOf(ch[j], i) + 1;
                set.clear();
                for (int k = i; k < j; k++) {
                    set.add(ch[k]);
                }
            }
            set.add(ch[j]);
            j++;
        }
        maxLen = Math.max(maxLen, j - i);
        return maxLen;
    }
}
