public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 必须在脑子清醒的时候做数学题
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int totalArea = (D - B) * (C - A) + (H - F) * (G - E);
        if (D > F && H > B && G > A && C > E) {
            totalArea -= (Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        }
        return totalArea;
    }
}
