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

    // Time:O(n) Space:O(1)
    // 2 pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (n > 0) {
            p1 = p1.next;
            n--;
        }
        if (p1 == null) {
            return p2.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
    }

    // Time:O(n) Space:O(1)
    // 1 pass
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p1 = newHead;
        ListNode p2 = newHead;
        int count = 0;
        while (p2 != null) {
            if (count < n) {
                p2 = p2.next;
                count++;
            } else {
                if (p2.next == null) {
                    p1.next = p1.next.next;
                }
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return newHead.next;
    }
}
