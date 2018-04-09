import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int left = input.nextInt();
        int right = input.nextInt();
        Main m = new Main();
        System.out.println(m.selfDividingNumbers(left, right));
    }

    //Time:O(n) Space:O(n)
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int k = left; k <= right; k++) {
            boolean flag = false;
            int i = k;
            while (i != 0) {
                int j = i % 10;
                if(j == 0 || k % j != 0) {
                    flag = false;
                    break;
                }
                flag = true;
                i /= 10;
            }
            if(flag == true){
                list.add(k);
            }
        }
        return list;
    }
}

