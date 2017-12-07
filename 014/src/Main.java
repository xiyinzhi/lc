import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input strings:");
        String str = input.nextLine();
        String[] strings = str.split(",");
        String string = m.longestCommonPrefix(strings);
        System.out.println("Output: " + string);
        String string2 = m.longestCommonPrefix2(strings);
        System.out.println("Output: " + string2);
    }

    //convert string to char[], stupid o(n^2)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            s = findCommonPrefix(s, strs[i]);
            if (s.equals(null)) {
                return "";
            }
        }
        return s;
    }

    public String findCommonPrefix(String a, String b) {
        StringBuffer sb = new StringBuffer();
        char[] ch1 = a.toCharArray();
        char[] ch2 = b.toCharArray();
        for (int i = 0; i < Math.min(ch1.length, ch2.length); i++) {
            if (ch1[i] == ch2[i]) {
                sb.append(ch1[i]);
            } else {
                break;
            }
        }
        String s = sb.toString();
        return s;
    }

    //o(n^2) faster
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
