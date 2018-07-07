import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n+m) Space:O(n+m)
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> noteMap = new HashMap<>();
        Map<Character, Integer> magMap = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            if (noteMap.containsKey(c)) {
                int v = noteMap.get(c);
                noteMap.put(c, v + 1);
            } else {
                noteMap.put(c, 1);
            }
        }
        for (char c : magazine.toCharArray()) {
            if (magMap.containsKey(c)) {
                int v = magMap.get(c);
                magMap.put(c, v + 1);
            } else {
                magMap.put(c, 1);
            }
        }
        for (char c : noteMap.keySet()) {
            if (!(magMap.containsKey(c) && noteMap.get(c) <= magMap.get(c))) {
                return false;
            }
        }
        return true;
    }
}
