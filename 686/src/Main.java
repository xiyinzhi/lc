import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = null;
        System.out.println("Enter A:");
        A = br.readLine();

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String B = null;
        System.out.println("Enter B:");
        B = br2.readLine();

        int s = repeatedStringMatch(A, B);
        System.out.println("Return:");
        System.out.print(s);
    }

    public static int repeatedStringMatch(String A, String B) {
        int N = A.length();
        int M = B.length();
        StringBuffer sb = new StringBuffer(A);
        int t = 1;
        int s = 1;
        if (M > N)
            s += M % N == 0 ? M / N : M / N + 1;
        else
            s = 2;
        for (int i = 0; i < s; i++) {
            if (sb.indexOf(B) >= 0)
                return t;
            else {
                sb.append(A);
                t += 1;
            }
        }
        return -1;
    }

}
