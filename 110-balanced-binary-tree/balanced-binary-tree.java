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
 * Bottom-Up Approach to check if a binary tree is height-balanced.
 *
 * Summary:
 * - Efficiently determines if a tree is balanced by computing heights during post-order traversal.
 * - Returns -1 immediately if an unbalanced subtree is found.
 * - This avoids redundant height calculations seen in top-down approaches.
 *
 * Time Complexity: O(n) – each node is visited only once.
 * Space Complexity: O(h) – where h is the height of the tree (due to recursion stack).
 */
class Solution {
    // Main method: returns true if the tree is height-balanced
    public boolean isBalanced(TreeNode root) {
        // If height() returns -1, the tree is unbalanced
        return height(root) != -1;
    }

    // Helper method to compute height of subtree rooted at 'root'
    // Returns -1 if the subtree is not balanced
    private int height(TreeNode root) {
        // Base case: an empty node contributes a height of 0
        if (root == null)
            return 0;

        // Recursively get the height of the left subtree
        int l = height(root.left);

        // Recursively get the height of the right subtree
        int r = height(root.right);

        // If either subtree is unbalanced or height difference > 1, return -1
        if (l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;

        // Return height of current node as 1 + max height of its subtrees
        return Math.max(l, r) + 1;
    }
}