import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        Main m = new Main();
        System.out.println(m.isPowerOfTwo(a));
    }

    //Time:O(log2(n)) Space:O(1)
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int a = 0;
        while (n != 1) {
            a = n % 2;
            n = n / 2;
            if (a == 1) {
                return false;
            }
        }
        return true;
    }

    //按位计算 faster Time:O(log10(n)) Space:O(1)
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0)
            return false;
        int ones = 0;
        for (int i = 1; i <= 32; ++i) {
            ones += n & 1;
            n = n >> 1;
        }
        return ones == 1;
    }
}
