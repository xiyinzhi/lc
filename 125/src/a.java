/**
 * Created by xyz on 2019/3/18.
 */
public class a {

    public boolean isPalindrome(String s) {
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
