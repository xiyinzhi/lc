import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iter;
        private Integer curr;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            iter = iterator;
            curr = iter.hasNext() ? iter.next() : null;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return curr;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = curr;
            curr = iter.hasNext() ? iter.next() : null;
            return res;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }
    }
}
