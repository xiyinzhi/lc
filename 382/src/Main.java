import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class Solution {
        private int size;
        Random random = new Random();
        ListNode root;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            ListNode p = head;
            root = head;
            while (p != null) {
                size++;
                p = p.next;
            }
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int i = random.nextInt(size);
            ListNode p = root;
            while (i > 0) {
                i--;
                p = p.next;
            }
            return p.val;
        }
    }
}
