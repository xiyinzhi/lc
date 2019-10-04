public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.mySqrt(8));
    }

    public int mySqrt(int x) {
        int a = binarySearch(x, 0, x);
        return a;
    }

    public int binarySearch(int x, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2 + 1;
            if (Math.pow(mid, 2) > x) {
                return binarySearch(x, low, mid - 1);
            } else {
                return binarySearch(x, mid, high);
            }
        }
        return low;
    }

    // binary search
    // time:O(logn), Space:O(1)
    public int mySqrt2(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long temp = (long) Math.pow(mid, 2);
            if (temp == (long) x) {
                return mid;
            } else if (temp > (long) x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

}
