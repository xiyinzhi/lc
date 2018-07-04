import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                sb.append(c);
                set.add(c);
            }
        }

    }
}
