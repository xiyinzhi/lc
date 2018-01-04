import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        int n = input.nextInt();
        System.out.println("output:" + m.countAndSay(n));
    }

    //recursive o(n^2)
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            return sb.append("1").toString();
        }
        char[] ch = countAndSay(n - 1).toCharArray();
        int num = ch.length;
        char temp = ch[0];
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (ch[i] == temp) {
                count += 1;
            } else {
                sb.append(String.valueOf(count));
                sb.append(String.valueOf(temp));
                count = 1;
                temp = ch[i];
            }
            if (i == num - 1) {
                sb.append(String.valueOf(count));
                sb.append(String.valueOf(temp));
            }
        }
        return sb.toString();
    }

}
