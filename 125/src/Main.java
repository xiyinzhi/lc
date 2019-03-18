import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println("Output:" + m.isPalindrome(str));
    }

    //O(n)
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String str = sb.toString();
        str = str.toLowerCase();
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if ((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                sb.append(c);
            }
        }
        String str = sb.toString();
        int n = str.length();
        for (int k = 0; k < n / 2; k++) {
            if (str.charAt(k) != str.charAt(n - k - 1)) {
                return false;
            }
        }
        return true;
    }
}
