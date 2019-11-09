import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(list, "", 0, 0, n);
        return list;
    }

    // 不可以用StringBuilder，因为那样指向的就是一个对象，会一直append
    // dfs
    public void generate(List<String> list, String s, int left, int right, int n) {
        if (left < right || left > n) {
            return;
        }
        if (left == n && right == n) {
            list.add(s);
        }
        if (left < n) {
            generate(list, s + "(", left + 1, right, n);
        }
        if (right < n) {
            generate(list, s + ")", left, right + 1, n);
        }
    }
}
