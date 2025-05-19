/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
/**
 * Approach (DFS - Recursive):
 * - Base case: If the node is null, return 0.
 * - If one child is null, we must go down the other subtree (to find a valid leaf).
 * - If both children are present, take the minimum of their depths.
 *
 * Time Complexity: O(n) — in the worst case, visits every node.
 * Space Complexity: O(h) — due to recursion stack (h = tree height).
 */
class Solution {
    public int minDepth(TreeNode root) {
        // If the root is null, the depth is 0
        if (root == null)
            return 0;

        // If the left child is null, we must go through the right subtree
        if (root.left == null)
            return 1 + minDepth(root.right);

        // If the right child is null, we must go through the left subtree
        if (root.right == null)
            return 1 + minDepth(root.left);

        // If both children exist, return the minimum depth of the two subtrees
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}