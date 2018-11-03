public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.splitListToParts(main.newList(), 5);
        System.out.println("Hello World!");
    }

    public ListNode newList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode p = root;
        while (p != null) {
            len++;
            p = p.next;
        }
        int r = len % k;
        int partLen = len / k;
        ListNode[] listNodes = new ListNode[k];
        p = root;
        int index = 0;
        int i = 0;
        while (p != null) {
            if (index / (partLen + 1) <= r) {
                if (partLen == 0) {
                    listNodes[i] = p;
                    i++;
                    ListNode prev = p;
                    p = p.next;
                    prev.next = null;
                } else {
                    if ((index % (partLen + 1) == partLen) || (index % (partLen + 1) == 0)) {
                        if (index % (partLen + 1) == 0) {
                            listNodes[i] = p;
                            i++;
                            p = p.next;
                        }
                        if (index % (partLen + 1) == partLen) {
                            ListNode prev = p;
                            p = p.next;
                            prev.next = null;
                        }
                    } else {
                        p = p.next;
                    }
                }
            } else {
                if (partLen > 0) {
                    if (((index - (partLen + 1) * r) % partLen == partLen - 1) || ((index - (partLen + 1) * r) % partLen == 0)) {
                        if ((index - (partLen + 1) * r) % partLen == partLen - 1) {
                            ListNode prev = p;
                            p = p.next;
                            prev.next = null;
                        }
                        if ((index - (partLen + 1) * r) % partLen == 0) {
                            listNodes[i] = p;
                            i++;
                            p = p.next;
                        }
                    } else {
                        p = p.next;
                    }
                }
            }
            index++;
        }
        return listNodes;
    }

}
