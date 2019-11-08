import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 1};
        int k = 2;
        System.out.println(main.findKthLargest(nums, k));
    }

    /**
     * PriorityQueue, 注意当pq的size大于初始化大小后会自动增加size
     * Time:O(nlogk) Space:O(k)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
