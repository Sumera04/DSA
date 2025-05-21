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
 * Approach: Level-order Traversal (BFS)
 * - Use a queue to perform a breadth-first traversal of the tree.
 * - At each step, increment the node count and add the left and right children to the queue if they exist.
 * - This ensures that all nodes are visited exactly once.
 *
 * Time Complexity: O(n)
 * - Each node is visited once, so the total work done is linear in the number of nodes.
 *
 * Space Complexity: O(w)
 * - `w` is the maximum width of the tree (i.e., the max number of nodes at any level).
 * - In the worst case, the queue might store up to O(n) nodes (in a very wide or complete tree).
 */

class Solution {
    public int countNodes(TreeNode root) {
        // Edge case: empty tree
        if (root == null)
            return 0;

        // Queue for level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Counter for number of nodes
        int numOfNodes = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            // Remove node from queue and count it
            TreeNode node = queue.poll();
            numOfNodes++;

            // Enqueue left child if it exists
            if (node.left != null)
                queue.offer(node.left);

            // Enqueue right child if it exists
            if (node.right != null)
                queue.offer(node.right);
        }

        // Return the total number of nodes
        return numOfNodes;
    }
}
