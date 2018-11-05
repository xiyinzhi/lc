public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.compress("aabbccc".toCharArray()));
    }

    // Time:O(n) Space:O(1)
    public int compress(char[] chars) {
        int n = chars.length;
        if (n < 2) {
            return n;
        }
        int index = 0;
        char c = chars[0];
        int length = 1;
        for (int i = 1; i < n; i++) {
            if (c != chars[i]) {
                chars[index++] = c;
                if (length > 1) {
                    for (int j = 0; j < String.valueOf(length).length(); j++) {
                        chars[index++] = String.valueOf(length).charAt(j);
                    }
                }
                length = 0;
                c = chars[i];
            }
            length++;
        }
        chars[index++] = c;
        if (length > 1) {
            for (int j = 0; j < String.valueOf(length).length(); j++) {
                chars[index++] = String.valueOf(length).charAt(j);
            }
        }
        return index;
    }
}
