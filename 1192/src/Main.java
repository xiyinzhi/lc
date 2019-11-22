import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /**
     * only edges(bridge) that are not in any cycle
     * https://youtu.be/aZXi1unBdJA
     * Tarjan's alogorithm
     */

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (connections == null || connections.size() < 3) {
            return connections;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for (int i = 0; i < connections.size(); i++) {
            List<Integer> li = connections.get(i);
            graph.get(li.get(0)).add(li.get(1));
            graph.get(li.get(1)).add(li.get(0));
        }

        int[] order = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < n; i++) {
            if (order[i] == 0) {
                dfs(i, order, low, graph, res, i);
            }
        }

        return res;
    }

    int step = 0;

    public void dfs(int u, int[] order, int[] low, List<List<Integer>> graph, List<List<Integer>> res, int parent) {
        step++;
        order[u] = step;
        low[u] = step;
        List<Integer> adjlist = graph.get(u);
        for (int v : adjlist) {
            if (v == parent) {
                continue;
            } else {
                if (order[v] == 0) {
                    dfs(v, order, low, graph, res, u);
                    low[u] = Math.min(low[u], low[v]);
                    if (order[u] < low[v]) {
                        List<Integer> edge = new ArrayList<>();
                        edge.add(u);
                        edge.add(v);
                        res.add(edge);
                    }
                } else {
                    low[u] = Math.min(low[u], order[v]);
                }
            }
        }
    }
}
