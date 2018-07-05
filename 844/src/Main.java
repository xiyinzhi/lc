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

//    Can you do it in O(N) time and O(1) space?
//    I believe you have one difficulty here: When we meet a char, we are not sure if it will be still there or be deleted.
//
//    The point is iterating the String form the last Character!

//    However, we can do a back string compare (just like the title of problem).
//    If we do it backward, we meet a char and we can be sure this char won't be deleted.
//    If we meet a '#', it tell us we need to skip next lowercase char.

}
