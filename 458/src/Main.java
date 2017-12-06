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

    //This difficulty should be at least medium
    //TBC
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int num = 0;
        int times = minutesToTest % minutesToDie == 0 ? minutesToTest / minutesToDie : minutesToTest / minutesToDie + 1;
        for (int i = 1; i < buckets; i++) {

        }
        return num;
    }
}
