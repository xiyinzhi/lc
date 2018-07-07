public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public boolean judgeCircle(String moves) {
        int d1 = 0, d2 = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    d1++;
                    break;
                case 'D':
                    d1--;
                    break;
                case 'L':
                    d2++;
                    break;
                case 'R':
                    d2--;
                    break;
                default:
                    System.out.println("wrong instruction!");
                    break;
            }
        }
        return d1 == 0 && d2 == 0;
    }
}
