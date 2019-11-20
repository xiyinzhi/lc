import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // BFS + DFS
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == t.val && helper(node, t)) {
                    return true;
                }
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
        return false;
    }

    public boolean helper(TreeNode root, TreeNode t) {
        if (root == null && t == null) {
            return true;
        }
        if (root == null || t == null) {
            return false;
        }
        if (root.val == t.val) {
            return helper(root.left, t.left) && helper(root.right, t.right);
        } else {
            return false;
        }
    }
}
