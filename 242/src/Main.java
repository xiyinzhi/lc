import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //sorting Time:O(nlogn) Space:O(n)
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        for (int i = 0; i < n; i++) {
            if (chs[i] != cht[i]) {
                return false;
            }
        }
        return true;
    }

    //without sorting Time:O(n) Space:O(n)
    public boolean isAnagram2(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }
        int[] chars = new int[26];
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (int i = 0; i < n; i++) {
            chars[chs[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            chars[cht[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
