public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        String s = "bacdfeg";
        int k = 2;
        System.out.println(m.reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        int n = s.length();
        int q = n / (2 * k);
        int r = n % (2 * k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(s.charAt(i * 2 * k + k - j - 1));
            }
            sb.append(s.substring(i * 2 * k + k, i * 2 * k + 2 * k));
        }
        if (r >= k) {
            for (int j = 0; j < k; j++) {
                sb.append(s.charAt(q * 2 * k + k - j - 1));
            }
            r -= k;
            int temp = sb.length();
            sb.append(s.substring(temp, temp + r));
        } else {
            for (int j = 0; j < r; j++) {
                sb.append(s.charAt(q * 2 * k + r - j - 1));
            }
        }
        return sb.toString();
    }
}
