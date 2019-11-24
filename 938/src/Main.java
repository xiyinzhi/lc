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
    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                int val = node.val;
                if (val <= R && val >= L) {
                    sum += val;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                } else if (val < L) {
                    if (right != null) {
                        queue.offer(right);
                    }
                } else {
                    if (left != null) {
                        queue.offer(left);
                    }
                }
            }
        }
        return sum;
    }


    // DFS
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}
