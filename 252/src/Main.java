import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
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

    // main idea: exchange starts/ends doesn't change the overlapping relationships of intervals
    // Time:O(nlogn) sorting Space:O(n)
    public boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < n - 1; i++) {
            if (starts[i + 1] < ends[i]){
                return false;
            }
        }
        return true;
    }
}
