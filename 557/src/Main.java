public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        String s = "Let's take LeetCode contest";
        System.out.println(m.reverseWords(s));
    }

    //Time:O(n) Space:O(n)
    // if use char array, more efficient
    public String reverseWords(String s) {
        int p1 = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                sb.append(reverseString(s.substring(p1, i)));
                sb.append(' ');
                p1 = i + 1;
            } else if (i == n - 1) {
                sb.append(reverseString(s.substring(p1, n)));
            }
        }
        return sb.toString();
    }

    public String reverseString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(n - 1 - i));
        }
        return sb.toString();
    }
}
