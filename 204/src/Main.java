import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n^2) Space:O(n)
    // Time Limit Exceeded
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int key : set) {
                if (i % key == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                set.add(i);
            }
        }
        return set.size();
    }

    // amazing & best sol with Time:O(n) Space:O(n)
    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }

}
