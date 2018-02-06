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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }
        p = head;
        int mid = length / 2;
        ListNode q = null;
        for (int i = 0; i < mid; i++) {
            ListNode tempNext = p.next;
            p.next = q;
            q = p;
            p = tempNext;
        }
        if (length % 2 != 0) {
            p = p.next;
        }
        for (int i = 0; i < mid; i++) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
