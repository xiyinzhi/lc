public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * https://leetcode.com/problems/water-and-jug-problem/discuss/83720/Clear-Explanation-of-Why-Using-GCD
     *
     * if and only if ax+by=z, return true
     *
     * Here we need a little math -- Bezout's identity, which is:
     * We can always find a and b to satisfy ax + bx = d where d = gcd(x, y)
     *
     * Then z must be a*d, which means z%d ==0
     */
    public boolean canMeasureWater(int x, int y, int z) {
        // weird test case
        if (x + y < z) {
            return false;
        }
        // always make x<=y
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        // in case gcd=0
        if (x == 0 && y == 0) {
            return z == 0;
        }
        return z % gcd(y, x) == 0;
    }

    // Euclidean algorithm to find the "greatest common divisor"
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
