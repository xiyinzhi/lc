import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //Time:O(Max(n,m)) Space:O(Max(n,m))
    public List<Integer> addToArrayForm(int[] A, int K) {
        int n = A.length;
        List<Integer> res = new LinkedList<>();
        if (n < 1) {
            res.add(K);
            return res;
        }
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tempK = 0;
            if (K != 0) {
                tempK = K % 10;
                K = K / 10;
            }
            int temp = 0;
            temp = A[i] + tempK + carry;
            if (temp > 9) {
                carry = 1;
                temp = temp % 10;
            } else {
                carry = 0;
            }
            res.add(0, temp);
        }
        if (K != 0) {
            while (K > 0) {
                int tempK = K % 10;
                K = K / 10;
                int temp = tempK + carry;
                if (temp > 9) {
                    carry = 1;
                    temp = temp % 10;
                } else {
                    carry = 0;
                }
                res.add(0, temp);
            }
        }
        if (carry > 0) {
            res.add(0, carry);
        }
        return res;
    }
}
