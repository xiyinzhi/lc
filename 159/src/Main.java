import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int count = 0;
        int start = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, i);
            if (map.size() > 2) {
                count = i - start;
                maxLen = Math.max(maxLen, count);
                int minValue = Collections.min(map.values());
                for (char key : map.keySet()) {
                    if (map.get(key) == minValue) {
                        map.remove(key);
                        break;
                    }
                }
                start = minValue + 1;
            }
        }
        maxLen = Math.max(maxLen, n - start);
        return maxLen;
    }
}
