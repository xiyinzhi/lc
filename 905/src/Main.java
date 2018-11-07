public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int p1 = 0;
        int p2 = n - 1;
        while (p1 < p2) {
            while (A[p1] % 2 == 0 && p1 < p2) {
                p1++;
            }
            while (A[p2] % 2 != 0 && p1 < p2) {
                p2--;
            }
            if (A[p1] % 2 != 0 && A[p2] % 2 == 0) {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
            }
        }
        return A;
    }
}
