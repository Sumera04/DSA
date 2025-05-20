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

/*
Approach:
- Use Depth-First Search (DFS) to traverse the tree.
- Keep track of the cumulative sum (`currentSum`) from root to the current node.
- When a leaf node is reached, check if the `currentSum` equals `targetSum`.

Time Complexity: O(n)
- In the worst case, every node in the tree is visited once.

Space Complexity: O(h)
- h = height of the tree (due to recursive call stack).
- Worst case: O(n) for a skewed tree; O(log n) for a balanced tree.
*/
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }

    // Recursive helper method to perform DFS while keeping track of the current sum
    private boolean helper(TreeNode root, int targetSum, int currentSum) {
        if (root == null)
            return false;

        // Add the current node's value to the running sum
        currentSum += root.val;

        // If it's a leaf node, check if the path sum matches the target
        if (root.left == null && root.right == null)
            return targetSum == currentSum;

        // Recursively check the left and right subtrees
        return helper(root.left, targetSum, currentSum) ||
                helper(root.right, targetSum, currentSum);
    }
}
