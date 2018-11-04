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

    // Time:O(n) Space:O(n) best solution
    public boolean isIsomorphic2(String s, String t) {
        int[] pos1 = new int[256];
        int[] pos2 = new int[256];
        for (int i = s.length() - 1; i >= 0; --i) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (pos1[cs] != pos2[ct]) {
                return false;
            }
            pos1[cs] = pos2[ct] = i;
        }
        return true;
    }
}
