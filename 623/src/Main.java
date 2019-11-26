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

    // BFS
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        d -= 1;
        if (d == 0) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.size() != 0 && d > 0) {
            d--;
            int size = queue.size();
            if (d != 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    TreeNode newLeft = new TreeNode(v);
                    node.left = newLeft;
                    newLeft.left = left;

                    TreeNode newRight = new TreeNode(v);
                    node.right = newRight;
                    newRight.right = right;

                }
            }
        }
        return root;
    }
}
