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

    // BFS, Most Efficient solution!
    // Time:O(n) Space:O(1) n:number of nodes
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int depth = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            // for each level
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
