import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n*2^n) Space:O(2^n)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        if (nums == null) {
            return list;
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = map.getOrDefault(nums[i], 0);
            map.put(nums[i], v + 1);
        }
        int size = map.size();
        for (int key : map.keySet()) {
            int len = list.size();
            int freq = map.get(key);
            for (int j = 0; j < freq; j++) {
                for (int k = 0; k < len; k++) {
                    List<Integer> tempList = new ArrayList<>(list.get(k + j * len));
                    tempList.add(key);
                    list.add(tempList);
                }
            }
        }
        return list;
    }
}
