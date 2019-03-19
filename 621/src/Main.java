import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'B', 'B'};
        Main main = new Main();
        System.out.println(main.leastInterval(tasks, 2));
    }


    // Time:O(n) Space:O(1) best 100%!
    public int leastInterval(char[] tasks, int n) {
        int num = tasks.length;
        if (num == 0) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = 0; i < num; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int k = 0;
        for (int i = 25; i >= 0; i--) {
            if (count[i] != 0) {
                k++;
            } else {
                break;
            }
        }
        if ((n + 1) * (count[25] - 1) + 1 <= num && k > n + 1) {
            return num;
        } else {
            int c = 0;
            for (int i = 25; i >= 0; i--) {
                if (count[i] == count[25]) {
                    c++;
                } else {
                    break;
                }
            }
            return (n + 1) * (count[25] - 1) + c;
        }
    }
}
