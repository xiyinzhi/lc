import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
//        if (n != t.length()) {
//            return false;
//        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(s.charAt(i))) {
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
