public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // Time:O(n) Space:O(n)
    public int firstUniqChar(String s) {
        int[] times = new int[26];
        int[] firstIndex = new int[26];
        int i = 0;
        for(char c: s.toCharArray()){
            if(firstIndex[c-97]==0){
                firstIndex[c-97] = i;
            }
            times[c-97]++;
            i++;
        }
        int n = s.length();
        int leastIndex = n;
        for(int j =0;j<26;j++){
            if(times[j]==1){
                leastIndex = Math.min(leastIndex, firstIndex[j]);
            }
        }
        if(leastIndex == n){
            return -1;
        }else{
            return leastIndex;
        }
    }

    // use IndexOf() & lastIndexOf(), very concise
    // Time:O(n) Space:O(1)
    public int firstUniqChar2(String s) {
        int resIndex = s.length();
        if (resIndex == 0)
            return -1;

        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                resIndex = Math.min(resIndex, index);
            }
        }

        return resIndex == s.length() ? -1 : resIndex;
    }
}
