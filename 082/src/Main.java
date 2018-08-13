public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p = pHead;
        if (p == null) {
            return p;
        }
        int val = p.val;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                val = p.val;
                p = p.next;
            }
        }
        return pHead;
    }
}
