import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        int n = input.nextInt();
        System.out.println("output:" + m.countAndSay(n));
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if(n == 1){
            return sb.append("1").toString();
        }
        char [] ch = countAndSay(n-1).toCharArray();
    }
}
