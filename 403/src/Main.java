import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] stones = {0, 1, 3, 5, 7, 9, 10, 12};
        System.out.println(main.canCross2(stones));
    }

    /**
     * basic dfs, but TLE, so
     * update1: use HashSet instead of traverse part of the array to search k-1,k,k+1，依然TLE
     * update2: Pre-check & search k+1,k,k-1 因为跳得越远越有可能先到终点
     */
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        return helper(stones, 1, n, 1);
    }

    public boolean helper(int[] stones, int i, int n, int k) {
        if (i == n - 1) {
            return true;
        }
        int start = stones[i];
        boolean b1 = false, b2 = false, b3 = false;
        for (int j = i + 1; j < n && stones[j] <= start + k + 1; j++) {
            if (stones[j] == start + k - 1) {
                b1 = helper(stones, j, n, k - 1);
            }
            if (stones[j] == start + k) {
                b2 = helper(stones, j, n, k);
            }
            if (stones[j] == start + k + 1) {
                b3 = helper(stones, j, n, k + 1);
            }
        }
        return (b1 || b2 || b3);
    }

    public boolean canCross2(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            /** pre-check 神来之笔 若后一个大太多显然是跳不过去的*/
            if (i > 0 && stones[i] - stones[i - 1] > i) {
                return false;
            }
            set.add(stones[i]);
        }
        return helper2(set, 1, stones[n - 1], 1);
    }


    public boolean helper2(Set<Integer> set, int curr, int target, int k) {
        if (curr == target) {
            return true;
        }
        if (curr > target) {
            return false;
        }
        if (set.contains(curr + k + 1)) {
            if (helper2(set, curr + k + 1, target, k + 1)) {
                return true;
            }
        }
        if (set.contains(curr + k)) {
            if (helper2(set, curr + k, target, k)) {
                return true;
            }
        }
        if (k > 1 && set.contains(curr + k - 1)) {
            if (helper2(set, curr + k - 1, target, k - 1)) {
                return true;
            }
        }
        return false;
    }



}
