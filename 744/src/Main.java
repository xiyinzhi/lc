public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // binary search
    // time:O(n) ave:O(logn), worst case:O(n), Space:O(1)
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0;
        int high = n - 1;
        if (letters[high] - target <= 0) {
            return letters[low];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] == target) {
                if (letters[mid + 1] == letters[mid]) {
                    low = mid + 1;
                } else {
                    return letters[mid + 1];
                }
            } else if (letters[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }
}
