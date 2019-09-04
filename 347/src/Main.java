import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        Main main = new Main();
        System.out.println(main.topKFrequent(nums, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int v = map.get(nums[i]);
                map.put(nums[i], v + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        /** initial capacity: 11 可自己设置*/
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(11,
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        // 默认从小到大
                        return e1.getValue() - e2.getValue();
                    }
                });
        /** 构建min heap， 记住堆顶是最小值*/
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else if (queue.peek().getValue() < entry.getValue()) {
                queue.poll();
                queue.add(entry);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().getKey());
        }
        return list;
    }
}
