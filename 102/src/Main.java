import java.util.ArrayList;
import java.util.List;

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

    //recursive Time:O(n) Space:O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        mark(res, root, 0);
        return res;
    }

    public void mark(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height >= list.size()) {
            List<Integer> tempList = new ArrayList<>();
            list.add(tempList);
        }
        list.get(height).add(root.val);
        mark(list, root.left, height + 1);
        mark(list, root.right, height + 1);
    }

}
