import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Solution {
    private int[] increaseWeights;
    private int max;

    public Solution(int[] w) {
        int len = w.length;
        increaseWeights = new int[len];
        max = 0;
        for (int i = 0; i < len; i++) {
            max += w[i];
            increaseWeights[i] = max - 1;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int r = random.nextInt(max);
        int index = binarySearch(increaseWeights, r);
        return index;
    }

    public int binarySearch(int[] increaseWeights, int r) {
        int n = increaseWeights.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (increaseWeights[mid] == r) {
                return mid;
            } else if (increaseWeights[mid] < r) {
                low = mid + 1;
            } else {
                if (mid == 0 || increaseWeights[mid - 1] < r) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}