import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        long n = input.nextLong();
        System.out.println("output:" + m.hammingWeight2(n));
    }

    //convert to char[] o(1)
    public int hammingWeight(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int size = chars.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (chars[i] == '1') {
                count += 1;
            }
        }
        return count;
    }

    //use >> o(1)
    public int hammingWeight2(long n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count += 1;
            }
            n >>= 1;
        }
        return count;
    }
}
