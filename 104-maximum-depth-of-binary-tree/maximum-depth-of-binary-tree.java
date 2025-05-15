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
class Solution {
    public int maxDepth(TreeNode root) {
        // If the tree is empty, its depth is 0
        if (root == null)
            return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        // Start BFS traversal from the root
        queue.offer(root);

        // Traverse the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size(); // Number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Dequeue the next node

                // Enqueue the left child if it exists
                if (node.left != null)
                    queue.offer(node.left);

                // Enqueue the right child if it exists
                if (node.right != null)
                    queue.offer(node.right);
            }

            // After processing one level, increment depth
            depth++;
        }

        // Return the total depth after traversing all levels
        return depth;
    }
}
