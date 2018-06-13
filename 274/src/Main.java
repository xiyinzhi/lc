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

    // Time:O(n) Space:O(n)
    public int hIndex2(int[] citations) {
        if (citations == null || citations.length < 1) {
            return 0;
        }
        //h-index wouldn't exceed the total number of articles
        //for example, even it is cited[100, 98, 0, 1, 5], we will only care about the number of cites including or below 5
        int n = citations.length; //n: number of articles
        int[] count = new int[n + 1];
        for (int i : citations) {
            if (i < citations.length) {
                count[i]++;
            } else {
                count[n]++;
            }
        }
        int sum = 0;
        int max = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                max = i;
                break;
            }
        }
        return max;
    }

}
