import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n*m) Space:O(1)
    public String findLongestWord(String s, List<String> d) {
        int n = d.size();
        int len = 0;
        String longestWord = new String();
        for (int i = 0; i < n; i++) {
            int iLen = d.get(i).length();
            if (len <= iLen && iLen <= s.length()) {
                if (isPossible(s, d.get(i))) {
                    if (len == iLen) {
                        if (longestWord.compareTo(d.get(i)) <= 0) {
                            continue;
                        } else {
                            longestWord = d.get(i);
                            len = longestWord.length();
                        }
                    } else {
                        longestWord = d.get(i);
                        len = longestWord.length();
                    }
                } else {
                    continue;
                }
            }

        }
        return longestWord;
    }

    public boolean isPossible(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int j = 0;
        for (int i = 0; i < n1; i++) {
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
                if (j == n2) {
                    break;
                }
            }
        }
        return j == n2 ? true : false;
    }
}
