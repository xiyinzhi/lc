import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(N) Space:O(N)
    // but we can use 2 int[] arrays instead, much faster
    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> secretMap = new HashMap<>();
        Map<Character, Set<Integer>> guessMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (secretMap.containsKey(c)) {
                Set<Integer> tempSet = secretMap.get(c);
                tempSet.add(i);
                secretMap.put(c, tempSet);
            } else {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(i);
                secretMap.put(c, tempSet);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (guessMap.containsKey(c)) {
                Set<Integer> tempSet = guessMap.get(c);
                tempSet.add(i);
                guessMap.put(c, tempSet);
            } else {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(i);
                guessMap.put(c, tempSet);
            }
        }
        int countA = 0;
        int countB = 0;
        for (char c : guessMap.keySet()) {
            Set<Integer> guessSet = guessMap.get(c);
            if (secretMap.containsKey(c)) {
                Set<Integer> secSet = secretMap.get(c);
                int size1 = guessSet.size();
                int size2 = secSet.size();
                int tempCount = 0;
                for (int v : guessSet) {
                    if (secSet.contains(v)) {
                        tempCount++;
                    }
                }
                countA += tempCount;
                countB += Math.min(size1, size2) - tempCount;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(countA).append("A").append(countB).append("B");
        return sb.toString();
    }
}
