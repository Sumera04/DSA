/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * - Use BFS (level-order traversal) to find the minimum depth.
 * - As soon as we encounter the first leaf node, we return the current depth.
 *
 *  Why BFS?
 * - BFS guarantees the **first leaf node found** is the one with the **minimum depth**.
 * - Avoids unnecessary traversal of deeper nodes like DFS might do.
 *
 *  Time Complexity: O(n) — visits each node once in the worst case.
 *  Space Complexity: O(w) — width of the tree (max number of nodes at any level).
 */
class Solution {
    public int minDepth(TreeNode root) {
        // Base case: empty tree has depth -1 (could also be 0 depending on convention)
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        // Perform level-order traversal (BFS)
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++; // Increase depth at each level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                // If this is a leaf node, return the current depth
                if (node.left == null && node.right == null)
                    return depth;

                // Add child nodes to the queue for the next level
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        
        return depth;
    }
}
