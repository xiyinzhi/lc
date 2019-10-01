public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // binary search
    // Time:O(logN) Space:O(1)
    // but not the best, because have to call the slow function isBadVersion() twice for each comparison
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 1) {
                if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                    return mid;
                } else if (!isBadVersion(mid)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (isBadVersion(mid)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
