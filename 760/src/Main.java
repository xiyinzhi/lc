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
}
