public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * design hashmap
     * before jdk1.8, the basic data structure of hashmap is array + LinkedList
     * 注意loop里别忘记加p = p.next
     */
    class MyHashMap {

        class ListNode {
            int key, val;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private ListNode[] array;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            array = new ListNode[10000];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = getIndex(key);
            ListNode p = array[index];
            while (p != null) {
                if (p.key == key) {
                    p.val = value;
                    return;
                }
                p = p.next;
            }
            ListNode newNode = new ListNode(key, value);
            newNode.next = array[index];
            array[index] = newNode;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int index = getIndex(key);
            ListNode p = array[index];
            while (p != null) {
                if (p.key == key) {
                    return p.val;
                }
                p = p.next;
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = getIndex(key);
            ListNode prev = array[index];
            if (prev == null) {
                return;
            }
            if (prev.key == key) {
                array[index] = prev.next;
                prev.next = null;
                return;
            }
            ListNode p = prev.next;
            while (p != null) {
                if (p.key == key) {
                    prev.next = p.next;
                    return;
                }
                prev = prev.next;
                p = prev.next;
            }
        }

        public int getIndex(int key) {
            int index = Integer.hashCode(key) % 10000;
            return index;
        }
    }
}
