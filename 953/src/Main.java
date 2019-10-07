import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String[] words = {"word", "world", "row"};
        System.out.println(isAlienSorted(words, "worldabcefghijkmnpqstuvxyz"));
    }

    // if not use Comparator, could it be faster?
    // Time:O(m^2) Space:O(m)
    public static boolean isAlienSorted(String[] words, String order) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int n1 = s1.length();
                int n2 = s2.length();
                int n = Math.min(n1, n2);
                for (int i = 0; i < n; i++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    int diff = order.indexOf(c1) - order.indexOf(c2);
                    if (diff != 0) {
                        return diff;
                    }
                }
                return n1 - n2;
            }
        };

        int len = words.length;

        String[] tempWords = Arrays.copyOf(words, len);
        Arrays.sort(words, myComp);
        for (int i = 0; i < len; i++) {
            if (!tempWords[i].equals(words[i])) {
                return false;
            }
        }
        return true;

    }

}
