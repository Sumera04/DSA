/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*
Approach:
- Use DFS to traverse the graph.
- Maintain a map to track cloned nodes to avoid cycles and redundant processing.

Time Complexity: O(N + E)
- N = number of nodes
- E = number of edges

Space Complexity: O(N)
- For the visited map and recursion stack
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // Start DFS with an empty visited map
        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node originalNode, Map<Node, Node> map) {
        // If node is already cloned, return it
        if (map.containsKey(originalNode))
            return map.get(originalNode);

        // Clone the current node
        Node newNode = new Node(originalNode.val);

        // Mark this node as cloned
        map.put(originalNode, newNode);

        // Recursively clone all neighbors
        for (Node neighbor : originalNode.neighbors) {
            newNode.neighbors.add(dfs(neighbor, map));
        }

        return newNode;
    }
}