import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String str = String.valueOf(chs);
            if (!map.containsKey(str)) {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(str, tempList);
            } else {
                map.get(str).add(strs[i]);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }
}
