import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        String s = "0.0";
        System.out.println(main.isNumber(s));
    }

    // 这题是sb吧
    public boolean isNumber(String s) {
        String pattern = ("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)");
//        String pattern = "^\\s*((((\\+|-)?[1-9]*[0-9])|(\\.[0-9]+))|((\\+|-)?[1-9]*[0-9]\\.[0-9]+))(e((((\\+|-)?[1-9]*[0-9])|(\\.[0-9]+))|((\\+|-)?[1-9]*[0-9]\\.[0-9]+)))?\\s*$";
        return Pattern.matches(pattern, s);
    }
}
