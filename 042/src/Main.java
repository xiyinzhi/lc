public class Main {

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Main m = new Main();
        System.out.println(m.trap(heights));
    }

    // Time:O(n) Space:O(1)
    public int trap(int[] height) {
        int n = height.length;
        int start = 0, end = n - 1;
        int max = 0;
        int trap = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] != 0) {
                start = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (height[n - i - 1] != 0) {
                end = n - i - 1;
                break;
            }
        }
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        int max2 = 0;
        int max2Index = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] >= max2 && i != maxIndex) {
                max2 = height[i];
                max2Index = i;
            }
        }
        if (maxIndex > max2Index) {
            int tempIndex = max2Index;
            int temp = max2;
            max2Index = maxIndex;
            maxIndex = tempIndex;
            max2 = max;
            max = temp;
        }
        trap += Math.min(max, max2) * (max2Index - maxIndex - 1);
        for (int i = maxIndex + 1; i < max2Index; i++) {
            trap -= height[i];
        }
        int s = maxIndex, e = max2Index;
        int max3 = 0, max4 = 0;
        while (s > start || e < end) {
            if (s > start) {
                max3 = 0;
                for (int i = start; i < maxIndex; i++) {
                    if (height[i] > max3) {
                        max3 = height[i];
                        s = i;
                    }
                }
                trap += Math.min(max, max3) * (maxIndex - s - 1);
                for (int i = s + 1; i < maxIndex; i++) {
                    trap -= height[i];
                }
                maxIndex = s;
                max = max3;
            }
            if (e < end) {
                max4 = 0;
                for (int i = end; i > max2Index; i--) {
                    if (height[i] > max4) {
                        max4 = height[i];
                        e = i;
                    }
                }
                trap += Math.min(max4, max2) * (e - max2Index - 1);
                for (int i = max2Index + 1; i < e; i++) {
                    trap -= height[i];
                }
                max2Index = e;
                max2 = max4;
            }
        }
        return trap;
    }
}
