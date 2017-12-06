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

    //better o(1) 实际还是o(n)
    public String reverseString2(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    //better o(1) 实际还是o(n)
    public String reverseString3(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    //much better o(n) 交换次数n/2
    public String reverseString4(String s) {
        char[] c= s.toCharArray();
        int left = 0, right = c.length-1;
        while(left<right)
        {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;right--;
        }
        return new String(c);
    }

}
