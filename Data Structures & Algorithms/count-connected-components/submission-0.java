//import java.util.*;

class Solution {
    public int countComponents(int n, int[][] edges) {

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        // Visit every node
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                // New component found
                components++;

                dfs(i, graph, visited);
            }
        }

        return components;
    }

    private void dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited
    ) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}
