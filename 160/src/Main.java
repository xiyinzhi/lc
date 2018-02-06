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

    //brute force Time:O(M*N) Space:O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            p2 = headB;
            while (p2 != null) {
                if (p1 == p2) {
                    return p2;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return null;
    }

    //Time:O(M+N) Space:O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int length = 0;
        int sub = 0;
        while (p1 != null || p2 != null) {
            if (p1 == null && p2 != null) {
                sub++;
                p2 = p2.next;
            } else if (p1 != null && p2 == null) {
                sub--;
                p1 = p1.next;
            } else {
                length++;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        p1 = headA;
        p2 = headB;
        if (sub > 0) {
            for (int i = 0; i < Math.abs(sub); i++) {
                p2 = p2.next;
            }
        } else {
            for (int i = 0; i < Math.abs(sub); i++) {
                p1 = p1.next;
            }
        }
        for (int i = 0; i < length; i++) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

}
