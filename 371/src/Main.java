import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a:");
        int a = input.nextInt();
        System.out.println("Input b:");
        int b = input.nextInt();
        Main m = new Main();
        int sum = m.getSum(a, b);
        System.out.println("sum:" + sum);
    }

    public int getSum(int a, int b) {
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(~a);
        int k = ~a + 1;
        if (a < 0) {
            a = ~a + 1;
        }
        if (b < 0) {
            b = ~b + 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        while (a != 0 || flag) {
            int lastBitA = a & 1;
            int lastBitB = b & 1;

            if (!flag) {
                if ((lastBitA ^ lastBitB) == 0 && lastBitA == 1) {
                    flag = true;
                    sb.insert(0, 0);
                } else {
                    sb.insert(0, lastBitA ^ lastBitB);
                }
            } else {
                if ((lastBitA ^ lastBitB ^ 1) == 1 && lastBitA == 0) {
                    flag = false;
                    sb.insert(0, 1);
                } else {
                    sb.insert(0, lastBitA ^ lastBitB ^ 1);
                }
            }

            a >>= 1;
            b >>= 1;
        }
        return Integer.valueOf(sb.toString(), 2);
    }

    public int getSubstraction(int a, int b){

    }
}
