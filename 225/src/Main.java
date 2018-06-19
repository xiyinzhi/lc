import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.s();
        System.out.println("Hello World!");
    }

    public void s() {
        MyStack stack = new MyStack();

        stack.push(1);
//        stack.push(2);
//        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false
    }

    // Time-- push:O(1) pop:O(n) top:O(1) empty:O(1)
    // Space:O(1)
    // 2 queues implement a stack
    class MyStack {
        private Queue<Integer> input;
        private Queue<Integer> output;

        private int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            input = new LinkedList<>();
            output = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            input.offer(x);
            top = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (input.size() > 1) {
                output.offer(input.poll());
            }
            int last = input.poll();
            while (output.size() > 1) {
                input.offer(output.poll());
            }
            if (output.size() > 0) {
                top = output.peek();
                input.offer(output.poll());
            }
            return last;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return input.isEmpty();
        }
    }


}
