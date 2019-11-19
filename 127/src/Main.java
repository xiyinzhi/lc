import java.util.*;

public class Main {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strings = {"hot", "dot", "dog", "lot", "log"};
        List<String> wordList = Arrays.asList(strings);
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    /**
     * BFS
     * Time:O(?) Space:O(n)
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if (beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() == 0 ||
//                beginWord.length() != endWord.length()) {
//            return 0;
//        }
        int size = wordList.size();
        boolean isExsited = false;
        // 注意endWord必须在list中
        for (int j = 0; j < size; j++) {
            if (wordList.get(j).equals(endWord)) {
                isExsited = true;
            }
        }
        if (!isExsited) {
            return 0;
        }
        if (size == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 0;
        while (queue.size() != 0) {
            count++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String str = queue.poll();
                if (isLadder(str, endWord)) {
                    count++;
                    return count;
                }
                for (int j = 0; j < size; j++) {
                    String word = wordList.get(j);
                    if (!visited.contains(word)) {
                        if (isLadder(str, word)) {
                            visited.add(word);
                            queue.offer(word);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean isLadder(String s1, String s2) {
        int n = s1.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
