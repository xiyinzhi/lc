import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a:");
        int a = input.nextInt();
        Main m = new Main();
        int b = m.reverse(a);
        System.out.println("reverse:" + b);
        int c = m.reverse2(a);
        System.out.println("reverse2:" + c);
    }

    //convert int to string
    public int reverse(int x) {
        String str1 = Integer.toString(x);
        boolean negative = false;
        int n = str1.length();
        if (str1.substring(0, 1).equals("-")) {
            negative = true;
            str1 = str1.substring(1, n);
            n -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str1.substring(i, i + 1) != "0") {
                sb.insert(0, str1.substring(i, i + 1));
            }
        }
        if (negative) {
            sb.insert(0, "-");
        }
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            ans = 0;
        }
        return ans;
    }

    //use division and mod
    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
            if (x != 0 && (ans < -214748364 || ans > 214748364)) {
                ans = 0;
                break;
            }
        }
        return ans;
    }
}
