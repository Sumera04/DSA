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
 * Approach:
 * - Use a recursive DFS traversal.
 * - Pass a boolean flag `isLeftNode` to track whether the current node is a left child.
 * - If a node is a **leaf** and `isLeftNode` is true, add its value to the result.
 * - Sum up values from both left and right subtrees recursively.
 *
 * Time Complexity: O(n)
 * - Each node is visited once.
 *
 * Space Complexity: O(h)
 * - `h` is the height of the tree, due to recursion stack.
 *   Worst case: O(n) for skewed tree, O(log n) for balanced tree.
 */

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        // Start recursion with root, which is not a left node
        return helper(root, false);
    }

    /**
     * Recursive helper function to calculate sum of left leaves.
     *
     * @param root         Current node being traversed.
     * @param isLeftNode   True if this node is a left child.
     * @return             Sum of all left leaf node values in this subtree.
     */
    private int helper(TreeNode root, boolean isLeftNode) {
        // Base case: null node contributes 0 to the sum
        if (root == null)
            return 0;

        // If this is a left leaf node, return its value
        if (root.left == null && root.right == null && isLeftNode)
            return root.val;

        // Recurse on left and right children
        return helper(root.left, true) + helper(root.right, false);
    }
}
