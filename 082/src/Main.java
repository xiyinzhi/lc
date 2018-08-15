import java.util.HashSet;
import java.util.Set;

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

    // Time:O(n) Space:O(n)
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode p = pHead;
        if (p == null) {
            return p;
        }
        int val = p.val;
        Set<Integer> set = new HashSet<>();
        p = p.next;
        while (p != null) {
            if (val == p.val) {
                set.add(val);
            }
            val = p.val;
            p = p.next;
        }
        while (pHead != null) {
            if (set.contains(pHead.val)) {
                pHead = pHead.next;
            } else {
                break;
            }
        }
        if (pHead == null) {
            return pHead;
        }
        ListNode prev = pHead;
        p = prev.next;
        while (p != null) {
            if (set.contains(p.val)) {
                prev.next = p.next;
            } else {
                prev = prev.next;
            }
            p = p.next;
        }
        return pHead;
    }
}
