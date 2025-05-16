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
 * Top-Down Approach to check if a binary tree is height-balanced.
 *
 * Summary:
 * - For each node, compute the heights of its left and right subtrees.
 * - Check if the height difference is no more than 1.
 * - Recursively ensure both left and right subtrees are also balanced.
 *
 * Time Complexity: O(n²) in the worst case (due to repeated height calculations).
 * Space Complexity: O(h) where h is the height of the tree (due to recursion stack).
 */
class Solution {
    // Main method to check if a binary tree is height-balanced
    public boolean isBalanced(TreeNode root) {
        // An empty tree is balanced
        if (root == null)
            return true;

        // Check if current node is balanced:
        // 1. Height difference between left and right is no more than 1
        // 2. Left subtree is balanced
        // 3. Right subtree is balanced
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
               isBalanced(root.left) &&
               isBalanced(root.right); 
    }

    // Helper method to calculate the depth (height) of a subtree
    private int maxDepth(TreeNode root) {
        // An empty subtree has depth 0
        if (root == null)
            return 0;

        // Recursively find the depth of left and right subtrees
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        // Depth of current node is 1 plus the greater of its left or right subtree
        return 1 + Math.max(l, r);
    }
}
