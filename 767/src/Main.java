public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    // beat 100%, amazing!
    public String reorganizeString(String S) {
        char[] ch = S.toCharArray();
        int n = S.length();
        //'a':97 'z':122
        int[] counts = new int[123];
        for (int i = 0; i < n; i++) {
            counts[ch[i]]++;
        }

        int mark = 0;
        for (int i = 97; i < 123; i++) {
            if (counts[i] > (n + 1) / 2) {
                return "";
            } else if (counts[i] == (n + 1) / 2) {
                mark = i;
            }
        }

        char[] newCh = new char[n];
        int j = 0, k = 1;
        if (mark == 0) {
            for (int i = 97; i < 123; i++) {
                char temp = (char) i;
                while (counts[i] != 0 && j < n) {
                    newCh[j] = temp;
                    j += 2;
                    counts[i]--;
                }
                while (counts[i] != 0 && k < n) {
                    newCh[k] = temp;
                    k += 2;
                    counts[i]--;
                }
            }
        } else {
            char temp = (char) mark;
            while (j < n) {
                newCh[j] = temp;
                j += 2;
            }
            for (int i = 97; i < 123; i++) {
                temp = (char) i;
                while (i != mark && counts[i] != 0 && k < n) {
                    newCh[k] = temp;
                    k += 2;
                    counts[i]--;
                }
            }
        }

        // construct a String from char[]
        String str = new String(newCh);

        return str;
    }
}
