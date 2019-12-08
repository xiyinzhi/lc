public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public class Relation {
        public boolean knows(int a, int b) {
            return true;
        }
    }

    /**
     * 注意审题，必须直接a->b才算knows，这样就很简单了
     */
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int candidate = 0;
            for (int i = 1; i < n; i++) {
                if (knows(candidate, i)) {
                    candidate = i;
                }
            }
            for (int i = 0; i < candidate; i++) {
                if (knows(candidate, i)) {
                    return -1;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != candidate && !knows(i,candidate)) {
                    return -1;
                }
            }
            return candidate;
        }
    }
}
