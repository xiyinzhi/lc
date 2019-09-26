import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.powerfulIntegers(1, 1, 10));
    }

    // edge case: x==1 / y==1, Integer Overflow
    // Time:O(n*m*(n+m)) Space:O(n*m)
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                long num = pow(x, i) + pow(y, j);
                if (num > bound) {
                    break;
                } else {
                    set.add(num);
                    if (y == 1) {
                        break;
                    }
                }
            }
            if (pow(x, i) + 1 > bound || x == 1) {
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (long num : set) {
            list.add((int) num);
        }
        return list;
    }

    public long pow(int x, int i) {
        long res = 1;
        for (int j = 0; j < i; j++) {
            res *= (long) x;
        }
        return res;
    }
}
