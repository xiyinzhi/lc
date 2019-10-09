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

    /**
     * 方法1：写出merge 2 sorted linkedlist，然后归并 时间O(nklogk) 空间O(nk) n是最大list长度
     * 方法2：优先队列构建大小为k的最小堆，时间O(nklogk) 空间O(nk)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k < 1) {
            return null;
        }
        while (k > 1) {
            int n = k / 2;
            int reminder = k % 2;
            for (int i = 0; i < n; i++) {
                ListNode l = mergeTwoLists(lists[2 * i], lists[2 * i + 1]);
                lists[i] = l;
            }
            if (reminder == 1) {
                lists[n] = lists[k - 1];
                n++;
            }
            k = n;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = p1 == null ? p2 : p1;
        return res.next;
    }
}
