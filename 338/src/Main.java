public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int digit = 1;
        for (int i = 1; i <= num; i++) {
            if (i == 2 * digit) {
                digit = 2 * digit;
            }
            res[i] = res[i - digit] + 1;
        }
        return res;
    }
}
