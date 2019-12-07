public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // combination
    public int uniquePaths(int m, int n) {
        long res = 1L;
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }
        for (int i = m + n - 2; i > n - 1; i--) {
            res *= i;
            res /= (m + n - 1 - i);
        }
        return (int) res;
    }
}
