import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(m.uniqueMorseRepresentations(words));
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        int n = words.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(morse[c - 97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
