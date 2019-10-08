public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n^2) Space:O(n)
    // could be more efficient by recording start/end positions, and return the substring of s
    // also helper() could be improved
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String temp = helper(s, n, i);
            if (temp.length() > maxLen) {
                maxLen = temp.length();
                res.append(temp);
            }
        }
        String resString = res.toString();
        int length = resString.length();
        return resString.substring(length - maxLen);
    }

    public String helper(String s, int n, int i) {
        int k = 1;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s.charAt(i));
        while (i + k < n && i >= k) {
            if (s.charAt(i + k) == s.charAt(i - k)) {
                sb1.append(s.charAt(i - k));
                sb1.insert(0, s.charAt(i - k));
                k++;
            } else {
                break;
            }
        }

        k = 0;
        StringBuilder sb2 = new StringBuilder();
        while (i + k < n && i - 1 >= k) {
            if (s.charAt(i + k) == s.charAt(i - k - 1)) {
                sb2.append(s.charAt(i - k - 1));
                sb2.insert(0, s.charAt(i - k - 1));
                k++;
            } else {
                break;
            }
        }
        if (sb1.length() >= sb2.length()) {
            return sb1.toString();
        } else {
            return sb2.toString();
        }

    }
}
