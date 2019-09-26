import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.fractionToDecimal2(-2147483648, 1));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        int integer = Math.abs(numerator) / Math.abs(denominator);
        sb.append(integer);
        int reminder = Math.abs(numerator) % Math.abs(denominator);
        if (reminder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(reminder, sb.length());
        while (reminder != 0) {
            reminder *= 10;
            int digit = reminder / Math.abs(denominator);
            sb.append(digit);
            reminder %= denominator;
            if (map.containsKey(reminder)) {
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            } else {
                map.put(reminder, sb.length());
            }
        }
        return sb.toString();
    }

    // pass all test cases!
    // pay attention to overflow and negative/0
    public String fractionToDecimal2(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        long integer = Math.abs((long) (numerator / denominator));
        sb.append(integer);
        long reminder = Math.abs((long) (numerator % denominator));
        if (reminder == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(reminder, sb.length());
        while (reminder != 0) {
            reminder *= 10;
            long digit = Math.abs((long) (reminder / denominator));
            sb.append(digit);
            reminder %= Math.abs((long) (denominator));
            if (map.containsKey(reminder)) {
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            } else {
                map.put(reminder, sb.length());
            }
        }
        return sb.toString();
    }
}
