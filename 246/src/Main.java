import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main m = new Main();
        System.out.println(m.isStrobogrammatic(scanner.next()));
    }

    //Time:O(n) Space:O(n)
    public boolean isStrobogrammatic(String num) {
        char[] ch = num.toCharArray();
        int n = ch.length;
        for (int i = 0; i < n / 2; i++) {
            if (ch[i] == '0' && ch[n - i - 1] == '0') {
                continue;
            }
            if (ch[i] == '1' && ch[n - i - 1] == '1') {
                continue;
            }
            if (ch[i] == '6' && ch[n - i - 1] == '9') {
                continue;
            }
            if (ch[i] == '9' && ch[n - i - 1] == '6') {
                continue;
            }
            if (ch[i] == '8' && ch[n - i - 1] == '8') {
                continue;
            }
            return false;
        }
        if (n % 2 == 1 && ch[n / 2] != '8' && ch[n / 2] != '0' && ch[n / 2] != '1') {
            return false;
        } else {
            return true;
        }

    }
}
