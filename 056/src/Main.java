import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("HelloWorld!");
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

    //O(nlogn)
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        //sort O(nlogn) amazing!
        intervals.sort((i, j) -> Integer.compare(i.start, j.start));

        List<Interval> newIntervals = new ArrayList<Interval>();
        newIntervals.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            int n = newIntervals.size();
            if (temp.start > newIntervals.get(n - 1).end) {
                newIntervals.add(temp);
            } else if (temp.start <= newIntervals.get(n - 1).end && temp.end > newIntervals.get(n - 1).end) {
                Interval newOne = newIntervals.get(n - 1);
                newIntervals.remove(n - 1);
                newOne.end = intervals.get(i).end;
                newIntervals.add(newOne);
            }
        }
        return newIntervals;
    }
}
