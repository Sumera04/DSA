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
    // BFS implementation
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Initialize a queue to hold node pairs from both trees
        Queue<TreeNode> queue = new LinkedList<>();

        // Add the root nodes of both trees to the queue
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            // Remove two nodes to compare
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // If both nodes are null, continue to the next pair
            if (left == null && right == null)
                continue;

            // If only one is null or values differ, trees are not the same
            if (left == null || right == null || left.val != right.val)
                return false;

            // Enqueue the left children of both nodes
            queue.offer(left.left);
            queue.offer(right.left);

            // Enqueue the right children of both nodes
            queue.offer(left.right);
            queue.offer(right.right);
        }

        // All nodes matched correctly
        return true;
    }
}