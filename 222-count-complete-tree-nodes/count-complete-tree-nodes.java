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
 * - Use a simple Depth-First Search (DFS) recursive traversal.
 * - At each node, count itself (1), then recursively count the nodes in the left and right subtrees.
 * 
 * Time Complexity: O(n)
 * - Each node is visited exactly once.
 * 
 * Space Complexity: O(h)
 * - h = height of the tree (due to recursive call stack).
 * - In the worst case (skewed tree), h = n. In the best case (balanced tree), h = log n.
 */

class Solution {
    public int countNodes(TreeNode root) {
        // Base case: if the node is null, return 0
        if (root == null)
            return 0;

        // Start with the current node
        int numOfNodes = 1;

        // Recursively count nodes in the left and right subtrees
        numOfNodes += countNodes(root.left);
        numOfNodes += countNodes(root.right);

        // Return total number of nodes in the tree
        return numOfNodes;
    }
}
