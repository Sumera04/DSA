/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // BFS implementation
    public int maxDepth(Node root) {
        // If the tree is empty, its depth is 0
        if (root == null)
            return 0;

        int depth = 0;
        Queue<Node> queue = new LinkedList<>();

        // Start BFS traversal from the root node
        queue.offer(root);

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                Node node = queue.poll(); // Dequeue the current node

                // Enqueue all non-null children of the current node
                List<Node> children = node.children;
                if (children != null) {
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }

            // After processing one level, increment the depth
            depth++;
        }

        // Return the maximum depth after traversing all levels
        return depth;
    }
}