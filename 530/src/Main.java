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

    // In-Order traverse, time complexity O(N), space complexity O(1).
    // guarantee the correctness, because in-order BST is sorted.

    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        getMinimumDifference(root.left);

        if (prev != Integer.MAX_VALUE) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }


}
