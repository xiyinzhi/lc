import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public int numUniqueEmails(String[] emails) {
        int n = emails.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] s = emails[i].split("@");
            String[] t = s[0].split("\\+");
            String s1 = t[0].replace(".", "");
            set.add(s1 + "@" + s[1]);
        }
        return set.size();
    }
}
