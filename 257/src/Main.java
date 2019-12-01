import java.util.ArrayList;
import java.util.List;

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, String.valueOf(root.val));
        return res;
    }

    public void dfs(TreeNode root, List<String> res, String str) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            dfs(left, res, str + "->" + String.valueOf(left.val));
        }
        if (right != null) {
            dfs(right, res, str + "->" + String.valueOf(right.val));
        }
        if (left == null && right == null) {
            res.add(str);
        }
    }
}
