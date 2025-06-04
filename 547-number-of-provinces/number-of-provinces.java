/*
Approach:
- The problem is to find the number of provinces (connected components in an undirected graph).
- The graph is represented as an adjacency matrix (isConnected).
- We'll use Depth First Search (DFS) to explore the connected cities.
- If a city has not been visited, it's part of a new province. We start DFS from that city to mark all cities in the same province as visited.

Time Complexity: O(N^2)
- We traverse the entire adjacency matrix once.

Space Complexity: O(N)
- For the visited array and recursion stack in the worst case (if the graph is fully connected).
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];  // Keeps track of visited cities
        int provinces = 0;

        // Iterate through each city
        for(int i = 0; i < n; i++) {
            // If the city is not visited, it's a new province
            if(visited[i] == 0) {
                provinces++;  // Increment province count
                dfs(isConnected, i, visited, n);  // Start DFS from this city
            }
        }

        return provinces;  // Return the total number of provinces
    }

    // Depth First Search to visit all cities connected to 'source'
    private void dfs(int[][] isConnected, int source, int[] visited, int n) {
        // Mark the current city as visited
        visited[source] = 1;

        for(int i = 0; i < n; i++) {
            // If city 'i' is connected to 'source' and not visited
            if(isConnected[source][i] == 1 && visited[i] == 0) {
                dfs(isConnected, i, visited, n);  // Recursively visit it
            }
        }
    }
}
