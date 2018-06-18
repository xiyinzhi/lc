import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main m = new Main();
        m.s();
    }

    public void s() {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // Returns -3.
        minStack.pop();
        minStack.top();      // Returns 0.
        minStack.getMin();   // Returns -2.
    }

    class MinStack {

        private Stack stack;
        private Stack minStack;
        private int top;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            MinStack obj = new MinStack();
            int x = 2;
            obj.push(x);
            obj.pop();
            int param_3 = obj.top();
            int param_4 = obj.getMin();
        }

        public void push(int x) {
            stack.push(x);
            if (x < getMin()) {
                minStack.push(x);
            } else {
                minStack.push(getMin());
            }
            top = x;

        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            } else {
                stack.pop();
                minStack.pop();
                top = Integer.parseInt(stack.peek().toString());
            }
        }

        public int top() {
            return top;

        }

        public int getMin() {
            return Integer.parseInt(minStack.peek().toString());
        }
    }

    class MinStack2 {

        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.peek() == min) {
                stack.pop();
                min = stack.pop();
            } else stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
