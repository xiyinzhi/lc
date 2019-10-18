import java.util.*;

public class Main {

    public static void main(String[] args) {
        TimeMap2 obj = new TimeMap2();
        obj.set("foo", "bar", 1);
        String param_2 = obj.get("foo", 1);
        System.out.println(param_2);
    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
    static class TimeMap {
        Map<String, TreeMap<Integer, String>> data;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            data = new HashMap<>();
        }

        // O(logn)
        public void set(String key, String value, int timestamp) {
            if (data.containsKey(key)) {
                TreeMap<Integer, String> treeMap = data.get(key);
                treeMap.put(timestamp, value);
            } else {
                TreeMap<Integer, String> treeMap = new TreeMap<>();
                treeMap.put(timestamp, value);
                data.put(key, treeMap);
            }
        }

        // This solution is good, but get TLE, use map.floorKey() instead!
        // O(n)
        public String get2(String key, int timestamp) {
            if (!data.containsKey(key)) {
                return "";
            } else {
                int prevTime = -1;
                TreeMap<Integer, String> treeMap = data.get(key);
                for (int tempTime : treeMap.keySet()) {
                    if (prevTime == -1 && timestamp < tempTime) {
                        return "";
                    } else if (timestamp < tempTime && timestamp >= prevTime) {
                        return treeMap.get(prevTime);
                    }
                    prevTime = tempTime;
                }
                return treeMap.get(prevTime);
            }
        }

        // O(1)?
        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = data.get(key);
            if (treeMap == null) {
                return "";
            }
            Integer floor = treeMap.floorKey(timestamp);
            if (floor == null) {
                return "";
            } else {
                return treeMap.get(floor);
            }
        }
    }

    /**
     * best solution: 因为输入的时间是有序的！
     */
    static class TimeMap2 {
        Map<String, List<Data>> map;

        class Data {
            String value;
            int timestamp;

            public Data(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        /**
         * Initialize your data structure here.
         */
        public TimeMap2() {
            map = new HashMap<>();
        }

        // O(1)
        public void set(String key, String value, int timestamp) {
            List<Data> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(new Data(value, timestamp));
                map.put(key, list);
            } else {
                list.add(new Data(value, timestamp));
                // list 获得了 reference，所以map里的值已经改变，不需要再put
            }
        }

        //O(logn)
        public String get(String key, int timestamp) {
            List<Data> list = map.get(key);
            if (list == null) {
                return "";
            }
            return binarySearch(list, timestamp);
        }

        public String binarySearch(List<Data> list, int t) {
            int size = list.size();
            int low = 0;
            int high = size - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid).timestamp == t) {
                    return list.get(mid).value;
                } else if (list.get(mid).timestamp > t) {
                    high = mid - 1;
                } else {
                    if (mid == size - 1 || list.get(mid + 1).timestamp > t) {
                        return list.get(mid).value;
                    } else {
                        low = mid + 1;
                    }
                }
            }
            return "";
        }
    }
}
