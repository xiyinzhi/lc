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
        stack.push(2);
        stack.top();   // returns 2
        stack.pop();   // returns 2
        stack.empty(); // returns false
    }

    // Time:O(1) Space:O(1)
    // 2 queues implement a stack

    class MyStack {
        private Queue<Integer> input;
        private Queue<Integer> output;

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
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {

        }

        /**
         * Get the top element.
         */
        public int top() {

        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {

        }
    }


}
