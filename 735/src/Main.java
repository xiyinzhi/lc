import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            if (stack.size() == 0 || stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else {
                if (asteroids[i] < 0) {
                    while (stack.size() > 0 && stack.peek() >= 0 && stack.peek() < -asteroids[i]) {
                        stack.pop();
                    }
                    if (stack.size() == 0 || stack.peek() < 0) {
                        stack.push(asteroids[i]);
                    } else if (stack.peek() == -asteroids[i]) {
                        stack.pop();
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            }
        }
        int m = stack.size();
        int[] res = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    /**
     * 有一种更优的方法，不用extra space
     * 只需要用双指针，一个在原数组里记录当前结果的end，一个记录现在走到的index
     * return 数组的[0-end]部分
     */
}
