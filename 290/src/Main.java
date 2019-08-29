import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.wordPattern("abba", "dog cat cat dog"));
    }

    // 易错点两个 1.判断字符串是否相等用equals() 2.key不同value相同的情况如何判别
    // Time:O(n) Space:O(n)
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        char[] chs = pattern.toCharArray();
        String[] strs = str.split(" ");
        int n = chs.length;
        if (n != strs.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(chs[i])) {
                if (!map.get(chs[i]).equals(strs[i])) {
                    return false;
                }
            } else {
                map.put(chs[i], strs[i]);
            }
        }
        Set<String> set = new HashSet<>();
        for (char c : map.keySet()) {
            if (!set.add(map.get(c))) {
                return false;
            }
        }
        return true;
    }
}
