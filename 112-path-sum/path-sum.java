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
 * \U0001f4a1 Approach (DFS - Recursive):
 * - Subtract the current node’s value from `targetSum`.
 * - Recursively check the left and right subtrees.
 * - If a leaf node is reached and the remaining sum is zero, return true.
 *
 * Time Complexity: O(n) — visit each node once.
 * Space Complexity: O(h) — recursion stack (h = height of the tree).
 */

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if tree is empty, there is no path
        if (root == null)
            return false;

        // If the current node is a leaf and its value equals the remaining targetSum
        if (root.left == null && root.right == null && root.val == targetSum)
            return true;

        // Recursively check left and right subtrees with updated targetSum
        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}
