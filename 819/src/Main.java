import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String s1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        main.mostCommonWord(s1, banned);
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split(" |!|\\?|'|,|;|\\.");
        int len = words.length;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int n = banned.length;
        for (int j = 0; j < n; j++) {
            set.add(banned[j]);
        }
        for (int i = 0; i < len; i++) {
            if (!set.contains(words[i])) {
                if (map.containsKey(words[i])) {
                    int v = map.get(words[i]);
                    map.put(words[i], v + 1);
                } else if (!words[i].equals("")) {
                    map.put(words[i], 1);
                }
            }
        }
        int max = 0;
        String res = null;
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                res = key;
                max = map.get(key);
            }
        }
        return res;
    }
}
