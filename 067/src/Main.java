import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String a = input.nextLine();
        String b = input.nextLine();
        System.out.println("output:" + m.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int n1 = a.length();
        int n2 = b.length();
        StringBuilder b2 = new StringBuilder(b);
        for (int i = 0; i < n1 - n2; i++) {
            b2.insert(0, '0');
        }
        char[] ch1 = a.toCharArray();
        char[] ch2 = b2.toString().toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            if (count == 0) {
                if (ch1[n1 - i - 1] == '1' && ch2[n1 - i - 1] == '1') {
                    count = 1;
                    sb.insert(0, '0');
                } else if (ch1[n1 - i - 1] == '0' && ch2[n1 - i - 1] == '1') {
                    count = 0;
                    sb.insert(0, '1');
                } else if (ch1[n1 - i - 1] == '1' && ch2[n1 - i - 1] == '0') {
                    count = 0;
                    sb.insert(0, '1');
                } else if (ch1[n1 - i - 1] == '0' && ch2[n1 - i - 1] == '0') {
                    count = 0;
                    sb.insert(0, '0');
                }
            } else {
                if (ch1[n1 - i - 1] == '1' && ch2[n1 - i - 1] == '1') {
                    count = 1;
                    sb.insert(0, '1');
                } else if (ch1[n1 - i - 1] == '0' && ch2[n1 - i - 1] == '1') {
                    count = 1;
                    sb.insert(0, '0');
                } else if (ch1[n1 - i - 1] == '1' && ch2[n1 - i - 1] == '0') {
                    count = 1;
                    sb.insert(0, '0');
                } else if (ch1[n1 - i - 1] == '0' && ch2[n1 - i - 1] == '0') {
                    count = 0;
                    sb.insert(0, '1');
                }
            }
        }
        if (count == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public String addBinary2(String a, String b) {
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        int n1 = a.length();
        int n2 = b.length();
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < n1; i++) {
            num1 += Integer.parseInt(String.valueOf(ch1[i])) * Math.pow(2, n1 - i - 1);
        }
        for (int i = 0; i < n2; i++) {
            num2 += Integer.parseInt(String.valueOf(ch2[i])) * Math.pow(2, n2 - i - 1);
        }
        int num = num1 + num2;
        String str = Integer.toBinaryString(num);
        return str;
    }

    public String addBinary3(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int temp1 = 0;
            int temp2 = 0;
            if (i < n1) {
                temp1 = a.charAt(n1 - i - 1) - '0';
            }
            if (i < n2) {
                temp2 = b.charAt(n2 - i - 1) - '0';
            }
            int temp = carry + temp1 + temp2;
            if (temp > 1) {
                carry = 1;
                temp = temp % 2;
            } else {
                carry = 0;
            }
            sb.append(String.valueOf(temp));
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
