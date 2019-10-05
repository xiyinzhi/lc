public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Traverse
     * Time:O(n) Space:O(1)
     */
    public double myPow(double x, int n) {
        if (n == 0 || x == 1 || (x == -1 && n % 2 == 0)) {
            return 1;
        } else if (x == 0) {
            return 0;
        } else if (x == -1 && n % 2 == 1) {
            return -1;
        } else {
            if (n < 0) {
                n = -1 - n;
                x = 1 / x;
            } else {
                n--;
            }
            double y = 1;
            while (n >= 0) {
                y *= x;
                n--;
                if (y == 0) {
                    return y;
                }
            }
            return y;
        }
    }

    /**
     * Great solution: using binary search, d&c, beat 100%
     * Time:O(logn) Space:O(1)
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half / x;
        }
    }
}
