public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // binary search
    // Time:O(logN) Space:O(1)
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public
}
