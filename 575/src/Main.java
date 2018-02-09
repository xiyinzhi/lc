import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

    public int distributeCandies(int[] candies) {
        if (candies == null) {
            return 0;
        }
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
}
