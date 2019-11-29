import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = letterCasePermutation("a1b2");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new LinkedList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        int n = S.length();
        permutation(S, res, 0, n);
        return res;
    }

    public static void permutation(String S, List<String> res, int index, int size) {
        if (index == size) {
            return;
        }
        int n = res.size();
        char c = S.charAt(index);
        // 原来character有这个内置函数，应该学习一下
        if (Character.isLetter(c)) {
            char upperc = Character.toUpperCase(c);
            char lowerc = Character.toLowerCase(c);
            if (n == 0) {
                res.add(String.valueOf(upperc));
                res.add(String.valueOf(lowerc));
            } else {
                for (int i = 0; i < n; i++) {
                    String str = res.get(0);
                    res.remove(str);
                    res.add(str + String.valueOf(upperc));
                    res.add(str + String.valueOf(lowerc));
                }
            }
        } else {
            if (n == 0) {
                res.add(String.valueOf(c));
            } else {
                for (int i = 0; i < n; i++) {
                    String str = res.get(0);
                    res.remove(str);
                    str += String.valueOf(c);
                    res.add(str);
                }
            }
        }
        permutation(S, res, index + 1, size);
    }
//
//    public static boolean isLetter(char c) {
//        if (c <= 'z' && c >= 'a') {
//            return true;
//        }
//        if (c <= 'Z' && c >= 'A') {
//            return true;
//        }
//        return false;
//    }

    public List<String> letterCasePermutation2(String s) {
        List<String> res = new LinkedList<>();
        helper(s.toCharArray(), 0, res);
        return res;
    }

    public void helper(char[] s, int pos, List<String> res) {
        if (pos >= s.length) {
            res.add(new String(s));
            return;
        }
        if (!Character.isLetter(s[pos])) {
            helper(s, pos + 1, res);
            return;
        }
        s[pos] = Character.toLowerCase(s[pos]);
        helper(s, pos + 1, res);

        s[pos] = Character.toUpperCase(s[pos]);
        helper(s, pos + 1, res);
    }
}
