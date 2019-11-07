public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 分治法
    // brilliant idea
    // Time:O(logn) Space:O(1)
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int reminder = n % 3;
        int k = n / 3;
        if (reminder == 1) {
            k--;
            reminder = 4;
        }
        if (reminder == 0) {
            reminder = 1;
        }
        return (int) Math.pow(3, k) * reminder;
    }
}
