import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String[] words = {"abdfs", "cccd", "a"};
        System.out.println(main.findWords(words));
    }

    // easy! use indexOf() 注意返回值
    // Time:O(n) Space:O(n)
    public String[] findWords(String[] words) {
        String str1 = "QWERTYUIOP";
        String str2 = "ASDFGHJKL";
        String str3 = "ZXCVBNM";
        List<String> list = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int temp1 = 1, temp2 = 1, temp3 = 1;
            for (char c : words[i].toUpperCase().toCharArray()) {
                if (str1.indexOf(c) >= 0) {
                    temp1 = -1;
                } else if (str2.indexOf(c) >= 0) {
                    temp2 = -1;
                } else {
                    temp3 = -1;
                }
            }
            if (temp1 + temp2 + temp3 == 1) {
                list.add(words[i]);
            }
        }
        int size = list.size();
        String[] strs = new String[size];
        for (int i = 0; i < size; i++) {
            strs[i] = list.get(i);
        }
        return strs;
    }
}
