import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Main m = new Main();
        System.out.println(m.trailingZeroes2(n));
    }

    //Time:O(n) Space:O(1)
    public int trailingZeroes(int n) {
        if (n < 1) {
            return 0;
        }
        long product = n;
        for (int i = 1; i < n; i++) {
            product *= i;
        }
        int k = 0;
        while (product % 10 == 0) {
            k++;
            product /= 10;
        }
        return k;
    }

    //Time:O(log5(n)) Space:O(1) Point: find the number of factor 5 in n!
    public int trailingZeroes2(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes2(n / 5);
    }
}