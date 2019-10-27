public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    // Time:O(m*n) Space:O(1)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return image;
        }
        int n = image.length;
        if (n == 0) {
            return image;
        }
        int m = image[0].length;
        int oldColor = image[sr][sc];
        // important ****
        if (oldColor == newColor) {
            return image;
        }
        DFSMarking(image, sr, sc, n, m, oldColor, newColor);
        return image;
    }

    public void DFSMarking(int[][] image, int sr, int sc, int n, int m, int oldColor, int newColor) {
        if (sr < 0 || sr >= n || sc < 0 || sc >= m || image[sr][sc] != oldColor) {
            return;
        } else {
            image[sr][sc] = newColor;
            DFSMarking(image, sr - 1, sc, n, m, oldColor, newColor);
            DFSMarking(image, sr + 1, sc, n, m, oldColor, newColor);
            DFSMarking(image, sr, sc - 1, n, m, oldColor, newColor);
            DFSMarking(image, sr, sc + 1, n, m, oldColor, newColor);
        }

    }
}
