public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.strStr("mississippi", "issip"));
    }

    public int strStr(String haystack, String needle) {
        char[] charHaystack = haystack.toCharArray();
        char[] charNeedles = needle.toCharArray();
        int n = haystack.length();
        int m = needle.length();
        if (m < 1) {
            return 0;
        }
        int p1 = -1;
        for (int i = 0; i < n - m + 1; i++) {
            if (charHaystack[i] == charNeedles[0]) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (charHaystack[i + j] != charNeedles[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    p1 = i;
                    break;
                }
            }
        }
        return p1;
    }
}
