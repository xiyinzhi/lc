public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private int n = 0;

    // Time:O(n) Space:O(n)
    public boolean isBipartite(int[][] graph) {
        if (graph == null) {
            return false;
        }
        n = graph.length;
        if (n == 0) {
            return false;
        }
        int[] marked = new int[n];
        for (int j = 0; j < n; j++) {
            if (!DFSMarking(graph, j, marked, 0)) {
                return false;
            }
        }
        return true;
    }

    public boolean DFSMarking(int[][] graph, int k, int[] marked, int prevNode) {
        if (k < 0 || k >= n) {
            return true;
        }
        if (marked[k] == 0) {
            if (prevNode == 0) {
                marked[k] = 1;
            } else if (prevNode == 1) {
                marked[k] = -1;
            } else {
                marked[k] = 1;
            }
        } else if (marked[k] == 1) {
            if (prevNode == 1) {
                return false;
            } else {
                return true;
            }
        } else {
            if (prevNode == -1) {
                return false;
            } else {
                return true;
            }
        }

        for (int i = 0; i < graph[k].length; i++) {
            if (!DFSMarking(graph, graph[k][i], marked, marked[k])) {
                return false;
            }
        }
        return true;

    }
}
