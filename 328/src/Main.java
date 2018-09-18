public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.oddEvenList(main.newList());
        System.out.println("Hello World!");
    }

    public ListNode newList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // Time:O(n) Space:O(1)
    public ListNode oddEvenList(ListNode head) {
        ListNode h1 = head;
        ListNode h2 = null;
        if (head != null) {
            h2 = head.next;
        }
        if (h1 == null || h2 == null) {
            return h1;
        }
        ListNode p = h2.next;
        ListNode p1 = h1;
        ListNode p2 = h2;
        int i = 3;
        while (p != null) {
            if (i % 2 == 1) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
            i++;
        }
        p1.next = null;
        p2.next = null;
        p1.next = h2;
        return h1;
    }
}
