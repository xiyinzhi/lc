import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public boolean isHappy(int n) {
        int temp = n;
        Set<Integer> set = new HashSet<>();
        while (temp != 1) {
            int newNum = 0;
            int len = String.valueOf(temp).length();
            while (temp != 0) {
                newNum += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            temp = newNum;
            if (!set.add(newNum) && temp != 1) {
                return false;
            }
        }
        return true;
    }
}
