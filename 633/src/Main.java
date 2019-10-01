import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 妙啊
    // Time:O(sqrt(n)) Space:O(sqrt(n))
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}
