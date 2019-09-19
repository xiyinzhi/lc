public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(Max(n1,n2)) Space:O(n1+n2)
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuilder sb = new StringBuilder();
        String num1Rev = new StringBuilder(num1).reverse().toString();
        String num2Rev = new StringBuilder(num2).reverse().toString();
        int d = 0;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int temp1 = 0;
            int temp2 = 0;
            if (n1 > i) {
                temp1 = num1Rev.charAt(i) - '0';
            }
            if (n2 > i) {
                temp2 = num2Rev.charAt(i) - '0';
            }
            int temp = temp1 + temp2 + d;
            if (temp > 9) {
                d = temp / 10;
                temp = temp % 10;
            } else {
                d = 0;
            }
            sb.append(String.valueOf(temp));
        }
        if (d > 0) {
            sb.append(d);
        }
        return sb.reverse().toString();
    }
}
