public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //Time:O(n) Space:O(n) can be O(1) if use 2 loops
    public boolean isArmstrong(int N) {
        int k = String.valueOf(N).length();
        long sum = 0;
        int tempN = N;
        while (tempN > 0) {
            sum += (long) Math.pow(tempN % 10, k);
            tempN /= 10;
        }
        if (sum == (long) N) {
            return true;
        } else {
            return false;
        }
    }
}
