import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * Definition for singly-linked list.
     **/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode root = new ListNode(0);
        ListNode res = root;
        while (l1 != null || l2 != null) {
            int sum = carry;
            /**
             * 统一的方法 取代if-else
             */
            sum += l1 != null ? l1.val : 0;
            sum += l2 != null ? l2.val : 0;
//            int sum = 0;
//            if (l1 == null) {
//                sum = l2.val + carry;
//            } else if (l2 == null) {
//                sum = l1.val + carry;
//            } else {
//                sum = l1.val + l2.val + carry;
//            }
            /**
             * 统一的方法 取代if-else
             */
            carry = sum / 10;
            res.next = new ListNode(sum % 10);
            res = res.next;
//            if (sum > 9) {
//                carry = 1;
//                res.next = new ListNode(sum - 10);
//                res = res.next;
//            } else {
//                carry = 0;
//                res.next = new ListNode(sum);
//                res = res.next;
//            }
            /**
             * important
             * null -> next is NullPointer
             */
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            res.next = new ListNode(carry);
            res = res.next;
        }
        return root.next;
    }

}
