public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int rotatedDigits(int N) {
        int len = String.valueOf(N).length();
        int count = 0;
        while (len > 0) {
            int i = N / (int) Math.pow(10, len - 1);
            if (i != 0) {
                int temp = (int) Math.pow(7, len - 1);
                if (i == 9) {
                    temp *= 6;
                } else if (i == 8) {
                    temp *= 5;
                } else if (i >= 6) {
                    temp *= 4;
                } else if (i == 5) {
                    temp *= 3;
                } else if (i >= 2) {
                    temp *= 2;
                }
                count += temp;
            }
            N = N - i * (int) Math.pow(10, len - 1);
            len--;
        }
        return count;
    }
}
