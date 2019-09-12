public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // math
    // recursive
    // Time:O(2^n) n:tree height Space:O(1)
    // Problem: StackOverflowError
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }
        return (reachingPoints(sx + sy, sy, tx, ty) || reachingPoints(sx, sx + sy, tx, ty));
    }
}
