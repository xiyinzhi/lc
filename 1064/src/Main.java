public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /** BinarySearch 经典题，注意条件是选择最小的*/
    //Time:O(logn) Space:O(1)
    public int fixedPoint(int[] A) {
        int n = A.length;
        int low = 0;
        int high = n - 1;
        int mark = Integer.MAX_VALUE;
        boolean flag = false;
        /** 注意是<= */
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == mid) {
                flag = true;
                mark = Math.min(mid, mark);
                high = mid - 1;
            } else if (A[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        if (!flag) {
            mark = -1;
        }
        return mark;
    }
}
