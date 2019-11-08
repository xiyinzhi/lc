public class Main {

    public static void main(String[] args) {
        System.out.println(reverseBits(429467293));
    }

    /**
     * must use bit manipulation, not divide
     */
    public static int reverseBits(int n) {
        long res = 0L;
        int i = 32;
        while (i > 0) {
            i--;
            int reminder = n & 1;
            n <<= 1;
            res >>= 1;
            res += reminder;
        }
        return (int) res;
    }
}
