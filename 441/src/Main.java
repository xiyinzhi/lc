public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(sqrt(n)) Space:O(1)
    // pay attention to overflow
    public int arrangeCoins(int n) {
        int i = 0;
        while ((long) i * (long) (i + 1) <= (long) 2 * (long) (n)) {
            i++;
        }
        return i - 1;
    }
}
