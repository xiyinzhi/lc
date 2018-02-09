import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Input:");
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(",");
        int n = strings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("Output: " + m.distributeCandies(candies));
    }

    //Time: O(nlogn) Space:O(n)
    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        Map<Integer, Integer> candyMap = new HashMap<>();
        int n = candies.length;
        int mark = candies[0];
        int quantity = 1;
        for (int i = 1; i < n; i++) {
            if (candies[i] == mark) {
                quantity++;
            } else {
                candyMap.put(mark, quantity);
                quantity = 1;
                mark = candies[i];
            }
        }
        candyMap.put(mark, quantity);
        int mapLen = candyMap.size();
        if (mapLen * 2 <= n) {
            return mapLen;
        } else {
            return n / 2;
        }
    }

    /**
     * if Map operations are not considered: Time: O(n) Space:O(n)
     * in fact, it is almost as slow as the first one
     */
    public int distributeCandies2(int[] candies) {
        Map<Integer, Integer> candyMap = new HashMap<>();
        int n = candies.length;
        int quantity;
        for (int i = 0; i < n; i++) {
            if (candyMap.containsKey(candies[i])) {
                quantity = candyMap.get(candies[i]) + 1;
                candyMap.remove(candies[i]);
                candyMap.put(candies[i], quantity);
            } else {
                candyMap.put(candies[i], 1);
            }
        }
        int mapLen = candyMap.size();
        //improve
        return Math.min(mapLen, n / 2);
    }

    /**
     * use Hash Set, because we don't need value
     * we only need the number of keys
     * Time: O(n) Space:O(n)
     */
    public int distributeCandies3(int[] candies) {
        Set<Integer> candySet = new HashSet<>();
        int n = candies.length;
        for (int i = 0; i < n; i++) {
            if (!candySet.contains(candies[i])) {
                candySet.add(candies[i]);
            }
        }
        int len = candySet.size();
        return Math.min(len, n / 2);
    }

    /**
     * in fact, we don't need Hash Set, we just need a count
     * but need sorting at first
     * Time: O(nlogn) Space:O(1)
     */
    public int distributeCandies4(int[] candies) {
        int count = 0;
        Arrays.sort(candies);
        int n = candies.length;
        for (int i = 0; i < n - 1; i++) {
            if (candies[i + 1] != candies[i]) {
                count++;
            }
        }
        count++;
        return Math.min(count, n / 2);
    }

    /**
     * Time: O(n) Space:O(n)
     */
    public int distributeCandies5(int[] candies) {
        int size = candies.length;
        int numKind = 0;
        int[] kinds = new int[200001];
        int inx;
        for (int candy : candies) {
            inx = candy + 100000;
            if (kinds[inx] == 0) {
                numKind++;
            }
            kinds[inx] += 1;
        }
        return Math.min(numKind, size / 2);
    }

    /**
     * the same thought with 5
     * but && count < half makes it faster than 5
     * Time: O(n) Space:O(n)
     */
    public int distributeCandies6(int[] candies) {
        boolean[] seen = new boolean[200001];
        int count = 0;
        int half = candies.length / 2;
        int inx;
        for (int i = 0; i < candies.length && count < half; i++) {
            inx = candies[i] + 100000;
            if (!seen[inx]) {
                count++;
                seen[inx] = true;
            }
        }
        return Math.min(count, half);
    }
}
