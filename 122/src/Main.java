public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 2 pointers
    // Time:O(n) Space:O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int p1 = 0, p2 = 0;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] > prices[p2]) {
                p2++;
            } else {
                maxProfit += prices[p2] - prices[p1];
                p1 = i;
                p2 = i;
            }
        }
        if (p1 < p2 && p2 == n - 1) {
            maxProfit += prices[p2] - prices[p1];
        }
        return maxProfit;
    }
}
