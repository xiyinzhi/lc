public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main main = new Main();
        main.similarRGB("#4e3fe1");
    }

    // Time&Space:O(1)
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 3; i++) {
            String s = color.substring(2 * i + 1, 2 * i + 3);
            int num = Integer.parseInt(s, 16);
            int q = num / 16;
            int r = num % 16;
            int res = 0;
            if (q != 0 && q != 15) {
                if (Math.abs(q - r) > Math.abs(q - 17 - r)) {
                    if (Math.abs(q - 17 - r) > Math.abs(q + 17 - r)) {
                        res = (q + 1) * 16 + q + 1;
                    } else {
                        res = (q - 1) * 16 + q - 1;
                    }
                } else {
                    if (Math.abs(q - r) < Math.abs(q + 17 - r)) {
                        res = q * 16 + q;
                    } else {
                        res = (q + 1) * 16 + q + 1;
                    }
                }
            } else if (q == 0) {
                if (17 - r > r) {
                    res = 0;
                } else {
                    res = 17;
                }
            } else {
                if (15 - r > r + 2) {
                    res = 14 * 16 + 14;
                } else {
                    res = 255;
                }
            }
            char a = (char) (res / 16 > 9 ? res / 16 - 10 + 'a' : res / 16 + '0');
            char b = (char) (res % 16 > 9 ? res % 16 - 10 + 'a' : res % 16 + '0');
            sb.append(a);
            sb.append(b);
        }
        return sb.toString();
    }

}
