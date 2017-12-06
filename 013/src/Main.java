import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a roman numeral: ");
        String s = input.nextLine();
        Main m = new Main();
        int num = m.romanToInt(s);
        System.out.println("Num: " + num);
    }

    public int romanToInt(String s) {
        String[] strings = s.split("");
        int size = strings.length;
        int sum = 0;
        int[] num = new int[size];
        for (int i = 0; i < size; i++) {
            if (strings[i].equals("I")) {
                num[i] = 1;
            }
            if (strings[i].equals("V")) {
                num[i] = 5;
            }
            if (strings[i].equals("X")) {
                num[i] = 10;
            }
            if (strings[i].equals("L")) {
                num[i] = 50;
            }
            if (strings[i].equals("C")) {
                num[i] = 100;
            }
            if (strings[i].equals("D")) {
                num[i] = 500;
            }
            if (strings[i].equals("M")) {
                num[i] = 1000;
            }
        }
        for (int i = 0; i < size; i++) {
            if (i < size - 1) {
                if (num[i] < num[i + 1]) {
                    sum -= num[i];
                } else {
                    sum += num[i];
                }
            } else {
                sum += num[i];
            }
        }
        return sum;
    }
}
