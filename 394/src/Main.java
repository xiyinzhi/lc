import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

    // 重点是[后面怎么判断
    public static String decodeString(String s) {
        if (s == null || s.length() < 4) {
            return s;
        }
        Stack<String> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (c == '[') {
                if (i != j) {
                    stack.push(s.substring(i, j));
                }
                i = j + 1;
            } else if (c == ']') {
                String str = "";
                if (i != j) {
                    str = s.substring(i, j);
                }
                while (isEncodedCharacter(stack.peek().charAt(0))) {
                    str = stack.pop() + str;
                }
                String prev = stack.pop();
                int k = Integer.parseInt(prev);
                StringBuilder sb = new StringBuilder();
                for (int index = 0; index < k; index++) {
                    sb.append(str);
                }
                if (stack.size() != 0 && isEncodedCharacter(stack.peek().charAt(0))) {
                    sb.insert(0, stack.pop());
                }
                stack.push(sb.toString());
                i = j + 1;
            } else if (isNumeric(c) && (j > 0 && isEncodedCharacter(s.charAt(j - 1)))) {
                stack.push(s.substring(i, j));
                i = j;
            } else if (j == n - 1) {
                stack.push(s.substring(i, n));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() != 0) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static boolean isNumeric(char c) {
        if (c <= '9' && c >= '0') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEncodedCharacter(char c) {
        if ((c > '9' || c < '0') && c != '[' && c != ']') {
            return true;
        } else {
            return false;
        }
    }
}
