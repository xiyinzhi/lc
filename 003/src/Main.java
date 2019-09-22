import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.lengthOfLongestSubstring("tmmzuxt"));
    }

    /**
     * Time:O(n) Space:O(1)
     * 改进时间：去掉while循环，可用HashMap代替HashSet，value存Char出现的position
     */
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
