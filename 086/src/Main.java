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

    // Time: O(n) Space:O(1)
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        boolean flag = false;
        if (head.val < x) {
            flag = true;
        } else {
            flag = false;
        }
        ListNode leftHead = head;
        ListNode rightHead = head;
        ListNode firstLeft = head;
        ListNode firstRight = head;
        if (flag) {
            while (leftHead.next != null && leftHead.next.val < x) {
                leftHead = leftHead.next;
            }
            if (leftHead.next == null) {
                return head;
            }
            rightHead = leftHead.next;
            firstRight = rightHead;
        } else {
            while (rightHead.next != null && rightHead.next.val >= x) {
                rightHead = rightHead.next;
            }
            if (rightHead.next == null) {
                return head;
            }
            leftHead = rightHead.next;
            firstLeft = leftHead;
        }
        ListNode prevleft = leftHead;
        ListNode prevright = rightHead;
        ListNode p = null;
        if (flag) {
            p = prevright.next;
        } else {
            p = prevleft.next;
        }
        while (p != null) {
            if (p.val < x) {
                prevleft.next = p;
                prevleft = prevleft.next;
            } else {
                prevright.next = p;
                prevright = prevright.next;
            }
            p = p.next;
        }
        prevright.next = null;
        prevleft.next = firstRight;
        return firstLeft;
    }

}
