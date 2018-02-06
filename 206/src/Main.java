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

    /**
     * iteration
     * insert each node in front of the reversedList
     * Time:O(n) Space:O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        while (q != null) {
            ListNode tempNext = q.next;
            q.next = p;
            p = q;
            q = tempNext;
        }
        return p;
    }

    /**
     * recursive
     * Time:O(n^2) Space:O(n)
     * The extra space comes from implicit stack space due to recursion. The recursion could go up to n levels deep.
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;

    }

    /**
     * recursive
     * Time:O(n) Space:O(n)
     * The extra space comes from implicit stack space due to recursion. The recursion could go up to n levels deep.
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
