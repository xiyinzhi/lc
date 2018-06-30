public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 2 pointers
    // Time:O(n) Space:O(1)
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            i++;
            if (i % 2 == 0) {
                q = q.next;
            }
            if (p == q && p != null) {
                return true;
            }
        }
        return false;
    }
}
