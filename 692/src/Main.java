import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    class Element {
        String key;
        int value;
    }

    /**
     * Method 1: build an extra class
     * Time:O(nlogk) Space:O(n+k)
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int v = map.getOrDefault(words[i], 0);
            v++;
            map.put(words[i], v);
        }
        List<Element> list = new ArrayList<>();
        for (String key : map.keySet()) {
            Element e = new Element();
            e.key = key;
            e.value = map.get(key);
            list.add(e);
        }
        int m = list.size();
        Comparator<Element> myComp = new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                if (e1.value != e2.value) {
                    return e2.value - e1.value;
                } else {
                    return e1.key.compareTo(e2.key);
                }
            }
        };
        PriorityQueue<Element> pq = new PriorityQueue<>(k, myComp);
        for (int i = 0; i < m; i++) {
            pq.offer(list.get(i));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().key);
        }
        return res;
    }

    /**
     * Method 2: doesn't need to build an extra class
     * Time:O(nlogk) Space:O(n+k)
     */
    public List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            int v = map.getOrDefault(words[i], 0);
            v++;
            map.put(words[i], v);
        }
        Comparator<Map.Entry<String, Integer>> myComp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                if (entry1.getValue() != entry2.getValue()) {
                    return entry2.getValue() - entry1.getValue();
                } else {
                    return entry1.getKey().compareTo(entry2.getKey());
                }
            }
        };
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k, myComp);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        return res;
    }

}
