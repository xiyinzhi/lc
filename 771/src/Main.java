import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(m+n) Space:O(n)
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int v = map.get(c) + 1;
                map.remove(c);
                map.put(c, v);
            }
        }
        int num = 0;
        for (char c : J.toCharArray()) {
            if (map.containsKey(c)) {
                num += map.get(c);
            }
        }
        return num;
    }


    // so elegant!
    // indexOf()
    // Time:O(m*n)? Space:O(1)
    public int numJewelsInStones2(String J, String S) {
        int jewelTot = 0;
        for (char stone : S.toCharArray()) {
            if (J.indexOf(stone) != -1) jewelTot++;
        }
        return jewelTot;
    }
}
