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
    public boolean isSymmetric(TreeNode root) {
        // A tree is symmetric if its left and right subtrees are mirror images
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        // If both nodes are null, this part of the tree is symmetric
        if (p == null && q == null)
            return true;

        // If only one of the nodes is null, the tree is not symmetric
        if (p == null || q == null)
            return false;

        // Check if the current node values are equal
        // and the left subtree of p mirrors the right subtree of q
        // and the right subtree of p mirrors the left subtree of q
        if (p.val == q.val &&
                helper(p.left, q.right) &&
                helper(p.right, q.left))
            return true;

        // If values don't match or subtrees aren't mirror images
        return false;
    }

}