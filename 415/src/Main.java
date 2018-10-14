public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int commonLength = 0;
        int prefix = 0;
        String preStr = new String();
        if (n1 > n2) {
            commonLength = n2;
            prefix = n1 - n2;
            preStr = num1.substring(0, n1 - n2);
        } else {
            commonLength = n1;
            prefix = n2 - n1;
            preStr = num1.substring(0, n2 - n1);
        }
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int[] add = new int[commonLength + 1];
        char[] ch = new char[commonLength + 1];
        for (int i = 0; i < commonLength; i++) {
            int s = add[commonLength - i] + ch1[n1 - i - 1] + ch2[n2 - i - 1] - 2 * '0';
            int r = 0;
            if (s > 9) {
                r = s - 10;
                add[commonLength - i - 1] = 1;
            } else {
                r = s;
            }
            ch[commonLength - i] = (char) (r + '0');
        }
        ch[0] = (char) (add[0] + '0');
        if (preStr == null || preStr == "") {
            return ch.toString();
        } else {
            char c = preStr.charAt(prefix - 1);
            preStr = preStr.substring(0, prefix - 1);

        }
    }
}
