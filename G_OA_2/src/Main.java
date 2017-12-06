import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        int[] A = new int[5];
////        System.out.println("Enter A:");
//
//        int[] B = new int[8];
////        System.out.println("Enter B:");
//
//        int s = longestUnivaluePath(A, B);
//        System.out.println("hello world!");
//        System.out.print(s);
        Main e = new Main();
//        int[] A = {4, -7, -3, -9, -3, 9, -7, 4, 6, -6, -6, 0, 6, 5, 9, -1, -4, -2};
//        int[] B = {1, 2, 1, 3, 4, 3, 5, 3, 5, 8, 4, 6, 4, 7, 6, 9, 9, 12, 12, 16, 9, 13, 13, 17, 7, 10, 10, 14, 7, 11, 11, 15, 15, 18};
        int[] A = {1, 1, 1, 1, 1,1};
        int[] E = {1, 2, 1, 3, 4, 1, 5, 1,1,6};
        int ans = e.solution(A, E);
        System.out.println("ans:" + ans);
    }

    // Definition for an undirected tree node.
    public class TreeNode {
        int nodeId;
        int label;
        List<TreeNode> children = new ArrayList<>();
        TreeNode parent;
    }

    private int longestLength;

    private TreeNode root;

    private int count = 0;

    public int solution(int[] A, int[] E) {
        longestLength = 0;
        if ((A.length - 1) * 2 != E.length)
            return 0;
        if (A == null || E == null)
            return 0;
        root = new TreeNode();
        root.nodeId = 1;
        root.label = A[0];

        constructTree(root, A, E);

        arrowLength(root);

        return longestLength;
    }

    public void constructTree(TreeNode node, int[] A, int[] E) {
        for (int i = 0; i < (A.length - 1) * 2; i++) {
            if (node.nodeId == E[i]) {
                TreeNode childNode = new TreeNode();
                if (i % 2 == 1) {
                    if (node == root || node.parent.nodeId != E[i - 1]) {
                        childNode.nodeId = E[i - 1];
                        childNode.parent = node;
                        childNode.label = A[childNode.nodeId - 1];
                        node.children.add(childNode);
//                        System.out.println("nodeId:" + node.nodeId + " label:" + node.label + " childId:" + childNode.nodeId + " label:" + childNode.label);
                        count += 2;
                        if (count == E.length)
                            return;
                        constructTree(childNode, A, E);
                    }
                }
                if (i % 2 == 0) {
                    if (node == root || node.parent.nodeId != E[i + 1]) {
                        childNode.nodeId = E[i + 1];
                        childNode.parent = node;
                        childNode.label = A[childNode.nodeId - 1];
                        node.children.add(childNode);
//                        System.out.println("nodeId:" + node.nodeId + " label:" + node.label + " childId:" + childNode.nodeId + " label:" + childNode.label);
                        count += 2;
                        if (count == E.length)
                            return;
                        constructTree(childNode, A, E);
                    }
                }
            }
        }
    }

    public int arrowLength(TreeNode node) {
        if (node == null)
            return 0;
        if (node.children.isEmpty())
            return 0;
        int childSize = node.children.size();

        int max1 = 0;
        int max2 = 0;
        int[] childLength = new int[childSize];
        int[] arrow = new int[childSize];

        if (childSize >= 1) {
            int temp = 0;
            for (int i = 0; i < childSize; i++) {
                childLength[i] = arrowLength(node.children.get(i));
                if (node.label == node.children.get(i).label)
                    arrow[i] = childLength[i] + 1;
                else
                    arrow[i] = 0;

                if (arrow[i] > temp) {
                    temp = arrow[i];
                    max2 = max1;
                    max1 = arrow[i];
                } else {
                    if (max2 == 0 || arrow[i] > max2)
                        max2 = arrow[i];
                }
            }
        }
        longestLength = Math.max(longestLength, max1 + max2);
        return Math.max(max1, max2);
    }

//    public static void insertionSort(int[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j > 0; j--) {
//                if (array[j - 1] <= array[j])
//                    break;
//                int temp = array[j];
//                array[j] = array[j - 1];
//                array[j - 1] = temp;
//            }
//        }
//    }

}
