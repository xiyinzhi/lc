import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        Main main = new Main();
        System.out.println(main.reorderLogFiles(strings));
    }


    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int p1 = s1.indexOf(" ");
                int p2 = s2.indexOf(" ");
                String sub1 = s1.substring(p1 + 1);
                String sub2 = s2.substring(p2 + 1);
                if (sub1.charAt(0) <= '9' && sub2.charAt(0) <= '9') {
                    return 0;
                } else if (sub1.charAt(0) > '9' && sub2.charAt(0) > '9') {
                    int preCompute = sub1.compareTo(sub2);
                    // if tie, compare identifier
                    if (preCompute != 0) {
                        return preCompute;
                    } else {
                        return s1.substring(0, p1).compareTo(s2.substring(0, p2));
                    }
                } else {
                    return sub2.charAt(0) - sub1.charAt(0);
                }
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }
}
