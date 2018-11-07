public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    //Time:O(n^2) Space:O(n)
    public String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (strs[i].charAt(0) == 'a' || strs[i].charAt(0) == 'e' || strs[i].charAt(0) == 'u' ||
                    strs[i].charAt(0) == 'i' || strs[i].charAt(0) == 'o' || strs[i].charAt(0) == 'A' ||
                    strs[i].charAt(0) == 'E' || strs[i].charAt(0) == 'U' || strs[i].charAt(0) == 'I' ||
                    strs[i].charAt(0) == 'O') {
                sb.append(strs[i]);
            } else {
                sb.append(strs[i].substring(1, strs[i].length())).append(strs[i].charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
