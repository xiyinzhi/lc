public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    char[] str;
    String s = str.toString();

    // Time:O(n) Space:O(n)
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        int n = strings.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!strings[n - i - 1].equals("")) {
                sb.append(strings[n - i - 1]).append(" ");
            }
        }
        // attention to len == 0
        int len = sb.length();
        if (len > 0) {
            sb.deleteCharAt(len - 1);
        }
        return sb.toString();
    }
}
