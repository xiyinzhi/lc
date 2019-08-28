import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    /**
     * 这个解法amazing,提供一个思路，如果length固定则可以用set巧妙解决，不需dp/2pointers
     */
    //Time:O(n) Space:O(n)
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> visited = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if (!visited.add(str)) {
                res.add(str);
            }
        }
        return new ArrayList(res);
    }
}
