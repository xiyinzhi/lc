import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        int n = input.nextInt();
        System.out.println("output:" + m.hammingWeight2(n));
    }

    //convert to char[] o(1)
    public int hammingWeight(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int size = chars.length;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (chars[i] == '1') {
                count += 1;
            }
        }
        return count;
    }

    //use >>> because n is unsigned  o(1)
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
