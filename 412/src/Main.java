import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<String> fizzBuzz(int n) {
        String m3 = "Fizz";
        String m5 = "Buzz";
        String m15 = "FizzBuzz";
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                list.add(String.valueOf(i));
            } else if (i % 3 != 0 && i % 5 == 0) {
                list.add(m5);
            } else if (i % 3 == 0 && i % 5 != 0) {
                list.add(m3);
            } else {
                list.add(m15);
            }
        }
        return list;
    }
}
