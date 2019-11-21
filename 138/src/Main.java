import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node p = head;
            while (p != null) {
//                map.put(p,new Node(p.val));
                Node newNode = new Node();
                newNode.val = p.val;
                map.put(p, newNode);

                p = p.next;
            }

            p = head;
            Node newHead = map.getOrDefault(p, null);
            while (p != null) {
                Node currNode = map.get(p);
                currNode.next = map.get(p.next);
                currNode.random = map.get(p.random);

                p = p.next;
            }

            return newHead;
        }
    }
}
