import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String s = input.nextLine();
        int k = input.nextInt();
        System.out.println("output:" + m.licenseKeyFormatting(s, k));
    }

    public String licenseKeyFormatting(String S, int K) {
        String str = S.toUpperCase();
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            if (ch[i] != '-') {
                sb.append(ch[i]);
            }
        }
        int n1 = sb.length();
        int c = n1 % K;
        for (int i = n1 / K - 1; i >= 0; i--) {
            if (c != 0 || i != 0) {
                sb.insert(c + i * K, '-');
            }
        }
        return sb.toString();
    }
}
