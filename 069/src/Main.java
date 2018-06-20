public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.mySqrt(8));
    }

    public int mySqrt(int x) {
        int a = binarySearch(x, 0, x);
        return a;
    }

    public int binarySearch(int x, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2+1;
            if (Math.pow(mid, 2) > x) {
                return binarySearch(x, low, mid-1);
            } else {
                return binarySearch(x, mid, high);
            }
        }
        return low;
    }

}
