import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Main m = new Main();
        System.out.println(m.isPowerOfThree(n));
    }

    //Time:O(log3(n)) Space:O(1)
    public boolean isPowerOfThree(int n) {
        if (n < 1 || n == 2) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int a = 0;
        while (n != 1 && n != 0) {
            a = n % 3;
            n = n / 3;
            if (a == 1 || a == 2) {
                return false;
            }
        }
        return true;
    }

    //faster Time:O(log3(n)) Space:O(1)
    public boolean isPowerOfThree2(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
