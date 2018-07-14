public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        int num = 3;
        System.out.println(m.intToRoman(num));
    }

    public String intToRoman(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int n = ch.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (n - i == 4) {
                for (int j = 0; j < ch[i] - '0'; j++) {
                    sb.append("M");
                }
                continue;
            }
            if (n - i == 3) {
                if (ch[i] - '0' == 4) {
                    sb.append("CD");
                } else if (ch[i] - '0' == 9) {
                    sb.append("CM");
                } else {
                    if (ch[i] - '0' > 4) {
                        sb.append("D");
                    }
                    int t = ch[i] - '0' > 4 ? ch[i] - '0' - 5 : ch[i] - '0';
                    for (int j = 0; j < t; j++) {
                        sb.append("C");
                    }
                }
                continue;
            }
            if (n - i == 2) {
                if (ch[i] - '0' == 4) {
                    sb.append("XL");
                } else if (ch[i] - '0' == 9) {
                    sb.append("XC");
                } else {
                    if (ch[i] - '0' > 4) {
                        sb.append("L");
                    }
                    int t = ch[i] - '0' > 4 ? ch[i] - '0' - 5 : ch[i] - '0';
                    for (int j = 0; j < t; j++) {
                        sb.append("X");
                    }
                }
                continue;
            }
            if (n - i == 1) {
                if (ch[i] - '0' == 4) {
                    sb.append("IV");
                } else if (ch[i] - '0' == 9) {
                    sb.append("IX");
                } else {
                    if (ch[i] - '0' > 4) {
                        sb.append("V");
                    }
                    int t = ch[i] - '0' > 4 ? ch[i] - '0' - 5 : ch[i] - '0';
                    for (int j = 0; j < t; j++) {
                        sb.append("I");
                    }
                }
                continue;
            }
        }
        return sb.toString();
    }
}
