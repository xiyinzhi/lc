
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // O(1), worst case O(∞)
    // pay attention, it is a general idea to do using randm implementing randn
    public int rand10() {
        int n = 11;
        while (n > 10) {
            n = 7 * (rand7() - 1) + rand7();
        }
        return n;
    }


}
