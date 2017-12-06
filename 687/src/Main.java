public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int longestLength;

    public int longestUnivaluePath(TreeNode root) {
        longestLength = 0;
        arrowLength(root);
        return longestLength;
    }

    public int arrowLength(TreeNode node){
        if(node == null)
            return 0;
        else{
            int left = arrowLength(node.left);
            int right = arrowLength(node.right);
            int arrowLeft = 0, arrowRight = 0;
            if(node.left != null && node.val == node.left.val)
                arrowLeft += left + 1;
            if(node.right != null && node.val == node.right.val)
                arrowRight += right + 1;
            longestLength = Math.max(longestLength, arrowLeft + arrowRight);
            return Math.max(arrowLeft, arrowRight);
        }
    }
}
