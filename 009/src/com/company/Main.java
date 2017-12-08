package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        int x = input.nextInt();
        System.out.println("output:" + m.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int temp = x;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (temp == y) {
            return true;
        } else {
            return false;
        }
    }
}
