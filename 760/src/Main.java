import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //Time: O(n^2) Space:O(n)
    public int[] anagramMappings(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        return res;
    }

    //Time: O(n) Space:O(n)
    public int[] anagramMappings2(int[] A, int[] B) {
        int l = A.length;
        int[] res = new int[l];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(B[i], i);
        }
        for (int i = 0; i < l; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }
}
