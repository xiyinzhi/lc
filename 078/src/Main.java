import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                /**
                 * 注意深拷贝的写法(how to deep copy a list)
                 */
                List<Integer> tempList = new ArrayList<>(list.get(j));
                tempList.add(nums[i]);
                list.add(tempList);
            }
        }
        return list;
    }
}
