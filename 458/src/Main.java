import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input buckets:");
        int buckets = input.nextInt();
        System.out.println("Input minutesToDie:");
        int minutesToDie = input.nextInt();
        System.out.println("Input minutesToTest:");
        int minutesToTest = input.nextInt();
        int num = m.poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println("Output: " + num);
    }

    // use n-dimension thinking
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int n = minutesToTest / minutesToDie + 1;//minimun test circle numbers
        int num = 0;
        while ((long) Math.pow(n, num) < (long) buckets) {
            num++;
        }
        return num;
    }
}
