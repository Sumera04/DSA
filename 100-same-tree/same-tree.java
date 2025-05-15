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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are identical at this point
        if (p == null && q == null)
            return true;

        // If one of the nodes is null and the other is not, trees are not identical
        if (p == null || q == null)
            return false;

        // Check if current node values are equal and recurse on left and right subtrees
        if (p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right))
            return true;

        // If values don't match or subtrees aren't identical
        return false;
    }
}