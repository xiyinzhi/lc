import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner input = new Scanner(System.in);
        System.out.println("Input nums:");
        String str = input.nextLine();
        String[] strings = str.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int num = m.singleNumber(nums);
        System.out.println("Output: " + num);
        int num2 = m.singleNumber2(nums);
        System.out.println("Output: " + num2);
    }

    //slow o(n) use map
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i],i);
            }
        }
        for (Integer key : map.keySet()) {
            n = key;
        }
        return n;
    }

    //fast o(n) use XOR
    public int singleNumber2(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
}