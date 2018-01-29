import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input:");
        String str = input.nextLine();
        System.out.println("Output:" + m.balance(str));
    }

    public String balance(String str) {
        StringBuilder sb = new StringBuilder(str);
        Stack stack = new Stack();
        int n = str.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() && str.charAt(i) == ')') {
                sb.insert(i + count, '(');
                count++;
            } else if (!stack.isEmpty() && str.charAt(i) == ')') {
                stack.pop();
            } else if (str.charAt(i) == '(') {
                stack.push('(');
            }
        }
        if (!stack.isEmpty()) {
            int num = stack.size();
            int len = sb.length();
            for (int i = 0; i < num; i++) {
                sb.insert(len + i, ')');
            }
        }
        return sb.toString();
    }
}
