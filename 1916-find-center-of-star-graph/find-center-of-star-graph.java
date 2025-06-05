    /**
     * Time Complexity: O(n), where n is the number of edges (since we iterate through all edges once)
     * Space Complexity: O(n), for storing the adjacency list
     */
class Solution {
    public int findCenter(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        // Build the adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Ensure the adjacency list is large enough
            while (adjList.size() <= Math.max(u, v)) {
                adjList.add(new ArrayList<>());
            }

            // Add the edge in both directions (undirected graph)
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Iterate through the adjacency list to find the center
        for (int i = 1; i < adjList.size(); i++) {
            List<Integer> neighbors = adjList.get(i);

            // In a star graph, only the center node connects to more than one node
            if (neighbors.size() > 1)
                return i;
        }

        return -1; // Should never reach here for a valid star graph
    }
}
