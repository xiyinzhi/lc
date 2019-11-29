import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.s();
        System.out.println("Hello World!");
    }

    public void s() {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.peek();  // returns 1
        queue.pop();   // returns 1
        queue.empty(); // returns false
    }

    //Time:O(1) Space:O(1)
    // 2 stacks implement a queue
    class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        public MyQueue() {
            input = new Stack();
            output = new Stack();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            peek();
            return output.pop();
        }

        public int peek() {
            if (output.empty()) {
                while (!input.empty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }

    // 其实和用queue实现stack完全一样
    class MyQueue2 {
        private Stack<Integer> s1;
        private Stack<Integer> s2;
        private Integer top;

        /**
         * Initialize your data structure here.
         */
        public MyQueue2() {
            s1 = new Stack();
            s2 = new Stack();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            s1.push(x);
            if (top == null) {
                top = x;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            top = s2.size() == 0 ? null : s2.peek();
            int pop = s1.pop();
            while (s2.size() > 0) {
                s1.push(s2.pop());
            }
            return pop;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return top;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty();
        }
    }
}
