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


    }
}
