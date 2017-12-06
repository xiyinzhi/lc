import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input n:");
        int n = input.nextInt();
        boolean canWin = m.canWinNim(n);
        System.out.println("Ans:" + canWin);
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
