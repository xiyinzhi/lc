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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n - k; i++) {
            p2 = p2.next;
        }
        ListNode newHead = p2;
        for (int i = 0; i < n - k - 1; i++) {
            p1 = p1.next;
        }
        for (int i = 0; i < k - 1; i++) {
            p2 = p2.next;
        }
        p1.next = null;
        p2.next = head;
        return newHead;
    }
}
