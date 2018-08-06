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
}
