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

    // DFS
    // Time:O(n) Space:O(1) n:number of nodes
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if ((root.left == null && root.right == null) || (root.left != null && root.right != null)) {
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            } else if (root.left == null) {
                return minDepth(root.right) + 1;
            } else {
                return minDepth(root.left) + 1;
            }

        }
    }
}
