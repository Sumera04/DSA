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
    public boolean isSymmetric(TreeNode root) {
        // An empty tree is considered symmetric
        if (root == null)
            return false;

        // Use a queue to compare nodes in pairs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            // Take two nodes to compare
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();

            // If both nodes are null, this pair is symmetric; continue
            if (p == null && q == null)
                continue;

            // If only one is null or values differ, tree is not symmetric
            if (p == null || q == null || p.val != q.val)
                return false;

            // Add the next set of nodes to compare
            // Mirror check: left with right and right with left
            queue.offer(p.left);
            queue.offer(q.right);

            queue.offer(p.right);
            queue.offer(q.left);
        }

        // All pairs matched symmetrically
        return true;
    }
}