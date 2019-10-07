import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    // 需要各种注意start/end条件
    // may use count+/- instead of stack to save space
    public static String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            end++;
            char c = S.charAt(i);
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
                start = i;
            }
            if (i != 0 && stack.isEmpty()) {
                sb.append(S.substring(start + 1, end - 1));
            }
        }
        return sb.toString();
    }
}
