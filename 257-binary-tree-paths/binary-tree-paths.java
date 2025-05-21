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
 * - Perform a DFS traversal of the binary tree.
 * - For each path from root to a leaf, build a string representing the path.
 * - When a leaf node is reached (both children are null), add the complete path to the result list.
 * 
 * Time Complexity: O(n^2)
 * - There are O(n) nodes, and each root-to-leaf path string could be up to O(n) characters long in the worst case.
 * 
 * Space Complexity: O(n)
 * - Due to the recursion stack in the worst case (skewed tree), and the result list storing all paths.
 */

class Solution {
    List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        helper(root, "");
        return result;
    }

    // Helper method to build path strings recursively
    private void helper(TreeNode node, String str) {
        // Base case: if node is null, do nothing
        if (node == null)
            return;

        // If leaf node is reached, add the full path to the result list
        if (node.left == null && node.right == null) {
            result.add(str + node.val);
            return;
        }

        // Append current node value and continue traversing
        helper(node.left, str + node.val + "->");
        helper(node.right, str + node.val + "->");
    }
}
