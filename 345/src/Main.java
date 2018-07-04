import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Use stack, Time:O(n) Space:O(n)
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        char[] ch = s.toCharArray();
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i' || c == 'A' || c == 'E' || c == 'I' || c == 'U'
                    || c == 'O') {
                stack.push(c);
            }
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'i' || ch[i] == 'A'
                    || ch[i] == 'E' || ch[i] == 'U' || ch[i] == 'I' || ch[i] == 'O') {
                ch[i] = stack.pop();
            }
        }
        return String.valueOf(ch);
    }

    // If use 2 pointer, use swap, skip this sol
    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
