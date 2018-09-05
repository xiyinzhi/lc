public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c <= 'Z' && c >= 'A') {
                sb.append((char) (c + ('a' - 'A')));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
