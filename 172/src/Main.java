import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Main m = new Main();
        System.out.println(m.trailingZeroes2(n));
    }

    //Time:O(n) Space:O(n)
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

    public int trailingZeroes2(int n) {
        if (n < 5) {
            return 0;
        }
        int k = n / 5;
        int c = (int) (Math.log(n) / Math.log(5)) - 1;
        while (c != 0) {
            k += c;
            c--;
        }
        return k;
    }
}
