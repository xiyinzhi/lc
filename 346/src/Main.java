import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // use Queue;
    // Time:O(n) Space:O(size)
    class MovingAverage {
        private long sum;
        private int maxSize;
        private Queue<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            q = new LinkedList<Integer>();
            maxSize = size;
        }

        public double next(int val) {
            if (q.size() == maxSize) {
                int prevNum = q.poll();
                sum -= prevNum;
            }
            q.offer(val);
            sum += val;
            return (double) sum / (double) q.size();
        }
    }
}
