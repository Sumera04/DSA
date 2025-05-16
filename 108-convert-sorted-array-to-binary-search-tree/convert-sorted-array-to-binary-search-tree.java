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
    public TreeNode sortedArrayToBST(int[] nums) {
        // Start the recursive construction of the BST
        return helper(nums, 0, nums.length - 1);
    }

    // Helper method to construct the BST from the subarray nums[low...high]
    private TreeNode helper(int[] nums, int low, int high) {
        // Base case: if the subarray is empty, return null
        if (low > high)
            return null;

        // Choose the middle element to maintain balance
        int mid = low + (high - low) / 2;

        // Create a TreeNode using the middle element
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the left subtree using the left half of the array
        node.left = helper(nums, low, mid - 1);

        // Recursively build the right subtree using the right half of the array
        node.right = helper(nums, mid + 1, high);

        // Return the current node as the root of this subtree
        return node;
    }
}