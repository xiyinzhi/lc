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
}
