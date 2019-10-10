public class Main {

    public static void main(String[] args) {
        System.out.println(confusingNumber(916));
    }

    public static boolean confusingNumber(int N) {
        String str = String.valueOf(N);
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == '8') {
                sb.append('8');
            } else if (str.charAt(i) == '0') {
                sb.append('0');
            } else if (str.charAt(i) == '1') {
                sb.append('1');
            } else if (str.charAt(i) == '6') {
                sb.append('9');
            } else if (str.charAt(i) == '9') {
                sb.append('6');
            } else {
                return false;
            }
        }
        String str2 = sb.toString();
        for (int i = 0; i < n - 1; i++) {
            if (str2.charAt(i) != '0') {
                str2 = str2.substring(i);
                break;
            }
        }
        if (str2.equals(str)) {
            return false;
        } else {
            return true;
        }
    }
}
