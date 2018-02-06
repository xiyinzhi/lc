public class Main {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        System.out.println("Hello World!");
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                deleteNode(node);
            }
            node = node.next;
        }
        return head;
    }

    public void deleteNode(ListNode node) {
        if (node.next == null) {
            //此处改变了node的值，但是返回main函数则显示无变化?why
            node = null;
        } else if (node.next.next == null) {
            node.val = node.next.val;
            node.next = null;
        } else {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;
            } else {
                //这一句在else里！
                pointer = pointer.next;
            }
        }
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

}
