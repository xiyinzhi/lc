public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = n, p2 = 0;
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        int i = 0;
        while (p2 < n && p1 < m + n) {
            nums1[i++] = nums2[p2] > nums1[p1] ? nums1[p1++] : nums2[p2++];
        }
        while (p2 < n) {
            nums1[i++] = nums2[p2++];
        }
    }
}
