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

    /**
     * recursively: max(maxDia(left),maxDia(right),maxDep(left)+maxDep(right))
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        maxDepth(root, 0);
        return maxDiameter;
    }

    private int maxDiameter;

    public int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth - 1;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int maxLeft = maxDepth(left, depth + 1);
        int maxRight = maxDepth(right, depth + 1);
        maxDiameter = Math.max(maxDiameter, maxLeft + maxRight - 2 * depth);
        return Math.max(maxLeft, maxRight);
    }
}
