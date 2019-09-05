import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

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

    //O(nlogn) mainly based on sorting
    // two pointers
    public int minMeetingRooms(Interval[] intervals) {
        int count = 0;
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        //O(nlogn)
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endIterator = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endIterator]) {
                count++;
            } else {
                endIterator++;
            }
        }
        return count;
    }
}
