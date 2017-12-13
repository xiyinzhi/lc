import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        int num = input.nextInt();
        System.out.println("output:" + m.addDigits(num));
    }

    public int addDigits(int num) {
        int n = 0;
        while (num != 0) {
            n += num % 10;
            num /= 10;
        }
        if (n > 9) {
            return addDigits(n);
        } else {
            return n;
        }
    }
}
