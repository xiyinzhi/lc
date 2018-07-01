public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 2 pointer
    // Time:O(n) Space:O(1)
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
