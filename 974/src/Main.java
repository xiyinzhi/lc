import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println((-6) % 5);
    }

    // Time:O(n) Space:O(k)
    // 523的变种，注意edge case: negative reminder
    public int subarraysDivByK(int[] A, int K) {
        int n = A.length;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        preSumMap.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += A[i];
            int r = sum % K;
            if (r < 0) {
                r += K;
            }
            if (preSumMap.containsKey(r)) {
                count += preSumMap.get(r);
            }
            preSumMap.put(r, preSumMap.getOrDefault(r, 0) + 1);
        }
        return count;
    }
}
