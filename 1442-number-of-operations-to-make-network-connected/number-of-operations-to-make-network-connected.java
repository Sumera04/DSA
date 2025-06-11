/*
Approach:
- To connect all `n` computers, we need at least (n - 1) connections.
- Build an adjacency list to represent the network.
- Use DFS to count the number of connected components.
- To connect all components, we need (components - 1) operations.

Time Complexity: O(n + e), where e = number of connections
Space Complexity: O(n + e), for adjacency list and visited array
*/

class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Step 1: If there are fewer than (n - 1) connections, it's impossible to connect all
        if (connections.length < n - 1)
            return -1;

        // Step 2: Create adjacency list to represent the network graph
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Step 3: Populate adjacency list with bidirectional edges (since network is undirected)
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Step 4: Count number of connected components using DFS
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            // If the node is not visited, it's part of a new component
            if (!visited[i]) {
                dfs(adjList, visited, i);  // explore the full component
                components++;              // increment component count
            }
        }

        // Step 5: To connect `components` together, we need (components - 1) cables
        return components - 1;
    }

    // Depth-First Search to mark all nodes in the current component as visited
    private void dfs(List<List<Integer>> list, boolean[] visited, int src) {
        visited[src] = true;
        for (int neighbor : list.get(src)) {
            if (!visited[neighbor]) {
                dfs(list, visited, neighbor);
            }
        }
    }
}