import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.lengthOfLongestSubstring("tmmzuxt"));
    }

    // Time:O(n) Space:O(n)
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        for (; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) {
                maxLen = Math.max(maxLen, j - i);
                while (s.charAt(j) != s.charAt(i)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
        }
        maxLen = Math.max(maxLen, j - i);
        return maxLen;
    }
}
