import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        List<Interval> intervals = new ArrayList<>();
        System.out.println("Hello World!");
    }

    /**
     * Definition for an interval.
     */
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    // Time:O(n) Space:O(1)
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        if (n < 1) {
            intervals.add(newInterval);
            return intervals;
        }

        int start = newInterval.start;
        int end = newInterval.end;
        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < n; i++) {
            if (end > intervals.get(n - 1).end) {
                endIndex = n;
                break;
            }
            if (end <= intervals.get(i).end) {
                endIndex = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (start > intervals.get(n - 1).start) {
                intervals.add(n, newInterval);
                startIndex = n;
                break;
            } else if (start <= intervals.get(i).start) {
                intervals.add(i, newInterval);
                startIndex = i;
                break;
            }
        }

        if (startIndex > endIndex) {
            for (int i = endIndex; i < startIndex; i++) {
                intervals.get(i + 1).end = intervals.get(i).end;
            }
            intervals.get(endIndex).end = end;
        } else if (startIndex < endIndex) {
            for (int i = startIndex; i < endIndex; i++) {
                intervals.get(i).end = intervals.get(i + 1).end;
            }
            intervals.get(endIndex).end = end;
        }

        for (int i = 0; i < n; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).end = intervals.get(i + 1).end;
                intervals.remove(i + 1);
                i--;
                n--;
            }
        }

        return intervals;
    }

    // Time:O(logn) Space:O(n)
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        // find the potential overlap area
        // m, index of the interval that ends after newInterval starts
        // n, index of the interval that starts befor newInterval ends

        List<Interval> result = new ArrayList<>();
        int m = findStartIndex(intervals, newInterval.start);
        int n = findEndIndex(intervals, newInterval.end);

        for (int i = 0; i < m; ++i) result.add(intervals.get(i));

        // smart thoughts!
        if (m <= n) {
            int start = Math.min(intervals.get(m).start, newInterval.start);
            int end = Math.max(intervals.get(n).end, newInterval.end);
            result.add(new Interval(start, end));
        } else result.add(newInterval);

        for (int i = n + 1; i < intervals.size(); ++i) result.add(intervals.get(i));
        return result;
    }

    // binary search
    int findStartIndex(List<Interval> intervals, int target) {
        int s = 0;
        int e = intervals.size() - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            Interval median = intervals.get(m);
            if (median.end == target) return m;
            if (median.end < target) s = m + 1;
            else e = m - 1;
        }

        return s;
    }

    // binary search
    int findEndIndex(List<Interval> intervals, int target) {
        int s = 0;
        int e = intervals.size() - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            Interval median = intervals.get(m);
            if (median.start == target) return m;
            if (median.start < target) s = m + 1;
            else e = m - 1;
        }

        return e;
    }

}
