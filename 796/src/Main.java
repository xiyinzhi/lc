public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && A.concat(A).contains(B);
    }
}
