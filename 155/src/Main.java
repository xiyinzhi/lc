import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
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
            if(x<getMin()){
                minStack.push(x);
            }else{
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
