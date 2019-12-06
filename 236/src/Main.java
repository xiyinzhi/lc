public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // recursive
    // Time:O(n) Space:O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right != null && left != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
