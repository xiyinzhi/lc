public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int min = prices[0];
        int maxprofit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - min > maxprofit) {
                maxprofit = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return maxprofit;
    }
}
