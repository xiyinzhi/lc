public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        ListNode head = m.defineLinkedList();
        m.insertionSortList2(head);
        System.out.println("Hello World!");
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

    //Brute Force Time:O(n^2) Space:O(n) 120ms
    public ListNode insertionSortList(ListNode head) {
        ListNode p = head;
        ListNode newList = null;
        while (p != null) {
            int temp = p.val;
            if (newList == null) {
                newList = new ListNode(temp);
            } else {
                ListNode newPrev = newList;
                ListNode q = newPrev.next;
                if (q == null) {
                    ListNode tempNode = new ListNode(p.val);
                    if (p.val < newPrev.val) {
                        tempNode.next = newPrev;
                        newPrev = tempNode;
                    } else {
                        newPrev.next = tempNode;
                    }
                    newList = newPrev;
                } else {
                    while (q != null) {
                        ListNode tempNode = new ListNode(p.val);
                        if (p.val < newPrev.val) {
                            tempNode.next = newPrev;
                            newPrev = tempNode;
                            newList = newPrev;
                            break;
                        }
                        if (p.val < q.val) {
                            newPrev.next = tempNode;
                            newPrev.next.next = q;
                            break;
                        } else if (q.next == null) {
                            q.next = tempNode;
                            break;
                        }
                        q = q.next;
                        newPrev = newPrev.next;
                    }
                }
            }
            p = p.next;
        }
        return newList;
    }

    //Time:O(n^2) Space:O(1) 7ms, Faster, big improvement
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode root = head;
        ListNode current = head.next;
        ListNode prev = head;

        while (current != null) {
            if(current.val >= prev.val){
                prev = current;
                current = current.next;
                continue;
            }
            prev.next = prev.next.next;
            if (current.val <= root.val) {
                current.next = root;
                root = current;
            }else {
                ListNode p = root;
                while (current.val >= p.next.val) {
                    p = p.next;
                }
                current.next = p.next;
                p.next = current;
            }
            current = prev.next;
        }
        return root;
    }
}
