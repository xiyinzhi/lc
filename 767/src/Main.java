public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public String reorganizeString(String S) {
        char[] ch = S.toCharArray();
        int n = S.length();
        //'a':97 'z':122
        int[] counts = new int[123];
        for (int i = 0; i < n; i++) {
            counts[ch[i]]++;
        }
        for (int i = 97; i < 123; i++) {
            if (counts[i] >= (n - 1) / 2){
                return "";
            }
        }
        return S;
    }
}
