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
 * Approach:
 * - This function recursively inverts a binary tree.
 * - For each node, it swaps the left and right child, and then recursively applies the same operation
 *   to the left and right subtrees.
 * 
 * Time Complexity: O(n)
 * - Every node in the tree is visited exactly once to swap its children.
 * 
 * Space Complexity: O(h)
 * - Where h is the height of the tree.
 * - In the worst case (skewed tree), the recursion stack can go up to O(n).
 * - In the best case (balanced tree), it will be O(log n).
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the node is null, return null
        if (root == null)
            return root;

        // Save references to the left and right subtrees
        TreeNode left = root.left;
        TreeNode right = root.right;

        // Recursively invert the right subtree and assign to left
        root.left = invertTree(right);

        // Recursively invert the left subtree and assign to right
        root.right = invertTree(left);

        // Return the current node after its children have been swapped
        return root;
    }
}
