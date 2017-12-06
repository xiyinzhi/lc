import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input x:");
        int x = input.nextInt();
        System.out.println("Input y:");
        int y = input.nextInt();
        int num = m.hammingDistance(x, y);
        System.out.println("Output: " + num);
        int num2 = m.hammingDistance2(x, y);
        System.out.println("Output2: " + num2);
    }

    //parse to char array
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        char[] chars = Integer.toBinaryString(ans).toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count += 1;
            }
        }
        return count;
    }

    //shift by bit, use &1 to calculate whether the last bit == 1
    public int hammingDistance2(int x, int y) {
        int ans = x ^ y;
        int count = 0;
        while (ans != 0) {
            count += ans & 1;
            ans >>= 1;
        }
        return count;
    }
}
