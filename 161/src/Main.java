public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isOneEditDistance("a", "A"));
    }

    // 这题并不是求 max common subsequence! kao
    // 因为不能 "ab", "ba"
    // Time:O(n) Space:O(1)
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        return isDelete(s, t) || isDelete(t, s) || isModify(s, t);
    }

    public boolean isDelete(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == m) {
            return false;
        }
        int min = Math.min(n, m);
        for (int i = 0; i < min; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1).equals(t.substring(i)) || s.substring(i).equals(t.substring(i + 1));
            }
        }
        return true;
    }

    public boolean isModify(String s, String t) {
        int diff = 0;
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
