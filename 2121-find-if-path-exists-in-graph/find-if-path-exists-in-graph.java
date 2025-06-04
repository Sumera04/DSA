// Time Complexity: O(V + E), where V is the number of nodes, E is the number of edges
// Space Complexity: O(V + E) for the adjacency list and O(V) for the visited array and recursion stack

// Approach:
// 1. Build an adjacency list from the edge list.
// 2. Use DFS starting from the source node to explore the graph.
// 3. Check if the destination node is reachable (visited).
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Populate adjacency list (since graph is undirected)
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 3: Create visited array and start DFS
        boolean[] visited = new boolean[n];
        dfs(adj, visited, source);

        // Step 4: Return whether destination was visited
        return visited[destination];
    }

    // DFS to mark all reachable nodes from src
    private void dfs(List<List<Integer>> adj, boolean[] visited, int src) {
        visited[src] = true;

        for (int neighbor : adj.get(src)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }
}
