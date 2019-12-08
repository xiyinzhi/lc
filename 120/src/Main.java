import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * bottom to top
     * easy DP, no extra space
     * Time:O(m*n)
     * 注意新学习了list.set(index, element)的用法
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1 || triangle.get(0).size() < 1) {
            return 0;
        }
        int n = triangle.size();
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
