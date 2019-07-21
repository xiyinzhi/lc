import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // use HashSet, can use int[] instead, which is fastest
    // Time:O(n) Space:O(n)
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        int n = G.length;
        for (int i = 0; i < n; i++) {
            set.add(G[i]);
        }
        ListNode p = head;
        int sum = 0;
        int count = 0;
        while (p != null) {
            if (set.contains(p.val)) {
                count++;
            } else {
                if (count > 0) {
                    sum++;
                    count = 0;
                }
            }
            p = p.next;
        }
        if (count > 0) {
            sum++;
        }
        return sum;
    }
}
