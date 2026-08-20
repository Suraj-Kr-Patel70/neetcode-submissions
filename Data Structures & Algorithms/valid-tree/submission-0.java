//import java.util.*;

class Solution {
    public boolean validTree(int n, int[][] edges) {

        // A tree with n nodes must have n - 1 edges
        if (edges.length != n - 1) {
            return false;
        }

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        // Start DFS from node 0
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        // Check that all nodes are connected
        for (boolean node : visited) {
            if (!node) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(
        int node,
        int parent,
        List<List<Integer>> graph,
        boolean[] visited
    ) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {

            // Ignore the edge back to parent
            if (neighbor == parent) {
                continue;
            }

            // Already visited = cycle
            if (visited[neighbor]) {
                return false;
            }

            if (!dfs(neighbor, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}