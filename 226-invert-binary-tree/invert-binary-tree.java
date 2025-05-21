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
 * Approach:
 * - This implementation uses a Breadth-First Search (BFS) approach to invert a binary tree.
 * - A queue is used to process each node level by level.
 * - For each node, its left and right children are swapped, and then the children are added to the queue.
 * 
 * Time Complexity: O(n)
 * - Each node is visited exactly once, and swapping left and right children takes constant time.
 * 
 * Space Complexity: O(n)
 * - In the worst case, the queue can hold up to O(n) nodes (when the tree is completely unbalanced).
 * - In a balanced tree, it will be O(w), where w is the maximum width of the tree.
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if tree is empty
        if (root == null)
            return null;

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Process nodes level by level
        while (!queue.isEmpty()) {
            // Remove the front node from the queue
            TreeNode node = queue.poll();

            // Swap the left and right children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add left and right children to the queue if they exist
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        // Return the root of the inverted tree
        return root;
    }
}
