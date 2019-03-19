public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.validPalindrome("eeccccbebaeeabebccceea"));
    }

    // Time:O(n) Space:O(1)
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if ((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                sb.append(c);
            }
        }
        String str = sb.toString();
        int n = str.length();
        int i = 0;
        int j = n - 1;
        boolean mark1 = true;
        boolean mark2 = true;
        for (int k = 0; k < n / 2; k++) {
            if (str.charAt(i) != str.charAt(j)) {
                int ii = i, jj = j, kk = k;
                if (str.charAt(ii) == str.charAt(jj - 1)) {
                    jj--;
                    for (; kk < n / 2; kk++) {
                        if (str.charAt(ii) != str.charAt(jj)) {
                            mark1 = false;
                            break;
                        }
                        ii++;
                        jj--;
                    }
                } else {
                    mark1 = false;
                }
                if (mark1) {
                    break;
                } else {
                    ii = i;
                    jj = j;
                    kk = k;
                }
                if (str.charAt(ii + 1) == str.charAt(jj)) {
                    ii++;
                    for (; kk < n / 2; kk++) {
                        if (str.charAt(ii) != str.charAt(jj)) {
                            mark2 = false;
                            break;
                        }
                        ii++;
                        jj--;
                    }
                } else {
                    mark2 = false;
                }
                if (mark2) {
                    break;
                }
                if ((str.charAt(ii) != str.charAt(jj - 1)) && (str.charAt(ii + 1) != str.charAt(jj))) {
                    return false;
                }
                if (!mark1 && !mark2) {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    // Time:O(n) Space:O(1)
    public boolean validPalindrome2(String s) {
        if (s == null || s.length() == 0) return true;
        return helper(s, 0, s.length() - 1, 0);
    }

    private boolean helper(String s, int left, int right, int n) {
        if (n > 1) return false;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // !!!brilliant
                return helper(s, left, right - 1, n + 1) || helper(s, left + 1, right, n + 1);
            }
        }
        return true;
    }

}