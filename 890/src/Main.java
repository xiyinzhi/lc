import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // general way: 2 maps
    // Time:O(m*n) Space:O(26)?
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int len = pattern.length();
        boolean isFind = true;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int j = 0; j < len; j++) {
                char cw = word.charAt(j);
                char cp = pattern.charAt(j);
                if (map1.containsKey(cp)) {
                    if (map1.get(cp) != cw) {
                        isFind = false;
                        break;
                    }
                } else {
                    map1.put(cp, cw);
                }
                if (map2.containsKey(cw)) {
                    if (map2.get(cw) != cp) {
                        isFind = false;
                        break;
                    }
                } else {
                    map2.put(cw, cp);
                }
            }
            if (isFind) {
                res.add(word);
            }
            isFind = true;
        }
        return res;
    }
}
