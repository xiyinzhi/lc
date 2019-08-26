public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //very easy
    // Time:O(n+m) Space:O(m)
    public char findTheDifference(String s, String t) {
        int[] fs = new int[26];
        for (char c : s.toCharArray()) {
            fs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            fs[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (fs[i] < 0) {
                return (char) (i + 'a');
            }
        }
        return '0';
    }
}
