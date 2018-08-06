public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] mincost = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                mincost[i] = cost[i];
            } else {
                mincost[i] = Math.min(mincost[i - 2], mincost[i - 1]);
                mincost[i] += i == n ? 0 : cost[i];
            }
        }
        return mincost[n];
    }
}
}
