import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    // search can be optimized using binary search
    public int[] twoSum(int[] numbers, int target) {
        Set<Integer> set = new HashSet<>();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            set.add(numbers[i]);
        }
        int a = 0;
        int[] index = new int[2];
        for (int i = 0; i < n; i++) {
            a = target - numbers[i];
            if (set.contains(a)) {
                index[0] = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (numbers[i] == a && i != index[0]) {
                index[1] = i;
                break;
            }
        }
        if (index[1] < index[0]) {
            int temp = index[1];
            index[1] = index[0];
            index[0] = temp;
        }
        index[0]++;
        index[1]++;
        return index;
    }
}
