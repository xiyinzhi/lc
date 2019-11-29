import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<List<Integer>> generate(int numRows) {
        int row = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (row <= numRows) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1) {
                    list.add(1);
                } else {
                    list.add(res.get(row - 2).get(i - 1) + res.get(row - 2).get(i));
                }
            }
            res.add(list);
            row++;
        }
        return res;
    }
}
