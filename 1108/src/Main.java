public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // boring, to examine regex and \\ usages
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}
