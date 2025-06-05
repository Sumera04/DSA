    /**
     * Approach:
     * - We are given a graph and a value array where vals[i] represents the value of node i.
     * - We want to find the maximum "star sum", defined as the sum of a node's value and the values
     *   of up to k of its neighbors with the highest positive values.
     * 
     * Steps:
     * 1. Build the adjacency list for the graph.
     * 2. For each node:
     *    a. Collect the values of its neighbors.
     *    b. Sort the neighbor values in descending order.
     *    c. Add up to k of the largest positive neighbor values to the node's own value.
     *    d. Track the maximum such sum.
     * 
     * Time Complexity: O(n + m + n log n), where:
     *   - n = number of nodes
     *   - m = number of edges
     *   - n log n comes from sorting each node's neighbors (in worst case, each node has n-1 neighbors)
     * 
     * Space Complexity: O(n + m), for storing the adjacency list
     */
class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;

        // Edge case: only one node or we can't include any neighbors
        if (n == 1 || k == 0)
            return vals[0];

        // Build the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int maxSum = Integer.MIN_VALUE;

        // For each node, compute its best possible star sum
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = adjList.get(i);
            List<Integer> neighborVals = new ArrayList<>();

            // Collect values of neighbors
            for (int neighbor : neighbors) {
                neighborVals.add(vals[neighbor]);
            }

            // Sort neighbor values in descending order to pick top k
            neighborVals.sort((a, b) -> b - a);

            int sum = vals[i]; // Start with the node's own value
            int count = 0;

            // Add up to k highest positive neighbor values
            for (int val : neighborVals) {
                if (count == k || val <= 0) 
                    break; // Stop if we've taken k or val is negative or zero
                sum += val;
                count++;
            }

            // Update maximum star sum
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
