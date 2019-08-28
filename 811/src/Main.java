import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        Main main = new Main();
        System.out.println(main.subdomainVisits(cpdomains));
    }

    /**
     * 坑1：regex for .
     * 坑2：使用indexof & substring 比 split快
     */
    // Time:O(n) Space:O(n)
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        int n = cpdomains.length;
        for (int i = 0; i < n; i++) {
//            String num = cpdomains[i].split(" ")[0];
//            int number = Integer.parseInt(num);
//            String s = cpdomains[i].split(" ")[1];
            /** 坑2：使用indexof & substring 比 split快 */
            int index = cpdomains[i].indexOf(' ');
            int number = Integer.parseInt(cpdomains[i].substring(0, index));
            String s = cpdomains[i].substring(index + 1);

            String[] domains = s.split("\\.");
            int partNum = domains.length;
            for (int j = 0; j < partNum; j++) {
                StringBuilder sb = new StringBuilder("");
                if (j == partNum - 1) {
                    sb.append(domains[j]);
                } else if (j == partNum - 2) {
                    sb.append(domains[j]).append(".").append(domains[j + 1]);
                } else {
                    sb.append(s);
                }
                String key = sb.toString();
                if (map.containsKey(key)) {
                    int v = map.get(key);
                    map.put(key, v + number);
                } else {
                    map.put(key, number);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            StringBuilder ressb = new StringBuilder("");
            ressb.append(String.valueOf(map.get(key))).append(" ").append(key);
            list.add(ressb.toString());
        }
        return list;
    }
}
