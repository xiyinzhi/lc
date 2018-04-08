import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Main m = new Main();
        System.out.println(m.isPowerOfFour(n));
    }

    //Time:O(log4(n)) Space:O(1)
    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }
}
