import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stackS.isEmpty() && c == '#') {
                stackS.pop();
            } else if (c != '#') {
                stackS.push(c);
            }
        }
        for (char c : T.toCharArray()) {
            if (!stackT.isEmpty() && c == '#') {
                stackT.pop();
            } else if (c != '#') {
                stackT.push(c);
            }
        }
        boolean flag = true;
        while (!stackS.isEmpty() && !stackT.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                flag = false;
                break;
            }
        }
        if (flag == true && stackS.isEmpty() && stackT.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
