import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - Math.max(m - 1, 0); i++) {
            if (isAnagrams2(s.substring(i, i + m), p)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        int n = p.length();
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int v = map.get(c);
                map.put(c, v + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int v = map.get(c);
                if (v < 1) {
                    return false;
                } else {
                    v--;
                    map.put(c, v);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    // Time:O(n*m) Space:O(n)
    public boolean isAnagrams2(String s, String p) {
        int[] ns = new int[26];
        int n = p.length();
        for (int i = 0; i < n; i++) {
            ns[p.charAt(i) - 'a']++;
            ns[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (ns[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // best sol: O(n) sliding window
}
