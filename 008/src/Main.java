public class Main {

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483647"));
    }

    // 史上最sb题目
    // edge case: leading 0, only 0, +,-, integer overflow etc.
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isValid = false;
        int startIndex = -1;
        int endIndex = -1;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c != ' ' && startIndex == -1) {
                if (c == '+' || c == '-') {
                    if (i < n - 1 && str.charAt(i + 1) <= '9' && str.charAt(i + 1) >= '0') {
                        isValid = true;
                        startIndex = str.indexOf(c);
                        endIndex = startIndex;
                    } else {
                        break;
                    }
                } else if (c <= '9' && c >= '0') {
                    isValid = true;
                    startIndex = str.indexOf(c);
                    endIndex = startIndex;
                } else {
                    break;
                }
            } else if (startIndex != -1) {
                if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    endIndex++;
                } else {
                    break;
                }
            }
        }
        if (!isValid) {
            return 0;
        }
        String num = str.substring(startIndex, endIndex + 1);
        int newStart = 0;
        int m = num.length();
        boolean isNegative = false;
        if (num.startsWith("-")) {
            isNegative = true;
        }
        while (newStart < m && (num.charAt(newStart) == '+' || num.charAt(newStart) == '-' || num.charAt(newStart) == '0')) {
            newStart++;
        }
        if (newStart == m) {
            return 0;
        }
        num = num.substring(newStart);
        if (isNegative) {
            num = "-" + num;
        }
        String minInteger = String.valueOf(Integer.MIN_VALUE);
        String maxInteger = String.valueOf(Integer.MAX_VALUE);
        if (num.startsWith("-")) {
            if (num.length() > minInteger.length() || (num.length() == minInteger.length() && num.compareTo(minInteger) >= 0)) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt(num);
            }
        } else {
            if (num.length() > maxInteger.length() || (num.length() == maxInteger.length() && num.compareTo(maxInteger) >= 0)) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.parseInt(num);
            }
        }
    }
}
