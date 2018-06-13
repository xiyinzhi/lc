import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // sorting
    // Time: O(nlogn) Space:O(1)
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n < 1) {
            return 0;
        }
        Arrays.sort(citations);
        int h = Math.min(citations[n - 1], n);
        for (int i = 0; i < n; i++) {
            if (h < n && h > 0) {
                if (citations[n - h - 1] <= h && citations[n - h] >= h) {
                    return h;
                }
            } else if (h == 0) {
                return h;
            } else {
                if (citations[0] >= h) {
                    return h;
                }
            }
            h--;
        }
        return h;
    }



}
