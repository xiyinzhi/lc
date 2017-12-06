import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input string:");
        String str = input.nextLine();
        String str2 = m.reverseString(str);
        System.out.println("After reverse:" + str2);
        String str3 = m.reverseString2(str);
        System.out.println("After reverse:" + str3);
    }

    //slowest o(n)
    public String reverseString(String s) {
        String[] strings = s.split("");
        int n = strings.length;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(strings[n - i - 1]);
        }
        return sb.toString();
    }

    //better o(1)
    public String reverseString2(String s) {
        return new StringBuffer(s).reverse().toString();
    }
}
