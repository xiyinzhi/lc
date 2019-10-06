public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int climbStairs(int n) {
        int[] odd = new int[n + 1];
        int[] even = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                odd[i] = 1;
                even[i] = 0;
            } else {
                odd[i] = even[i - 1] + odd[i - 1];
                even[i] = odd[i - 1];
            }
        }
        return odd[n] + even[n];
    }

    // 实际上就是斐波那契！
    public int climbStairs2(int n) {
        int prev = 1;
        int next = 2;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            while (n > 2) {
                prev += next;
                int temp = prev;
                prev = next;
                next = temp;
                n--;
            }
            return next;
        }
    }
}
