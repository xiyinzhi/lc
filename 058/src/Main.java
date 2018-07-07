public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (len != 0 && s.charAt(i) == ' ') {
                break;
            } else if (s.charAt(i) != ' ') {
                len++;
            }
        }
        return len;
    }
}
