public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        ListNode head = m.defineLinkedList();
        ListNode p = m.sortList(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public ListNode defineLinkedList() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        return head;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //because we need to sort in Time:O(nlogn) Space:O(1)
    //merge sort a linked list
    public ListNode sortList(ListNode head) {

        return head;
    }

}
