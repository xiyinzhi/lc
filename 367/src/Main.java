public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // binary search
    // Time:O(logN) Space:O(1)
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long midSquare = (long) mid * (long) mid;
            if (midSquare == (long) num) {
                return true;
            } else if (midSquare > (long) num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
