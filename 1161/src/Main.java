import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int levelSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int j = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                levelSum += queue.poll().val;
            }
            if (maxSum < levelSum) {
                maxSum = levelSum;
                level = j;
            }
            j++;
            levelSum = 0;
        }
        return level;
    }
}
