import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String s = input.nextLine();
        int k = input.nextInt();
        System.out.println("output:" + m.licenseKeyFormatting(s, k));
    }

    public String licenseKeyFormatting(String S, int K) {

    }
}
