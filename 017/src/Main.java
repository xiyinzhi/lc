import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("input:");
        String digits = input.nextLine();
        System.out.println("output:" + m.letterCombinations(digits));
    }

    private final static String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> letters = new ArrayList<>();
        List<String> sbs = letterCombination(0, digits, letters);
        return sbs;
    }

    //recursive O(4^n)?
    public List<String> letterCombination(int offset, String digits, List<String> letters) {
        int n = digits.length();
        if (n == 0) {
            return letters;
        }
        if (offset == n) {
            return letters;
        }
        char digitAtOffset = digits.charAt(offset);
        String letter = KEYS[digitAtOffset - '0'];
        char[] chars = letter.toCharArray();
        List<String> newLetters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int j = letters.size();
            if (letters.isEmpty()) {
                newLetters.add(String.valueOf(chars[i]));
            } else {
                for (int k = 0; k < j; k++) {
                    StringBuilder sb = new StringBuilder(letters.get(k));
                    sb.append(chars[i]);
                    newLetters.add(sb.toString());
                }
            }
        }
        return letterCombination(offset + 1, digits, newLetters);
    }

}
