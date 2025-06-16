/*
 * Approach:
 * - Initialize minVal with the first element.
 * - Traverse the array from the second element onwards.
 * - If current element is greater than minVal, update maxDiff with the difference.
 * - If current element is smaller or equal, update minVal to this element.
 * - Return maxDiff if found, else return -1.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = nums[0]; // Minimum value seen so far
        int maxDiff = -1; // Maximum difference initialized to minimum possible

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minVal) {
                // Current element is bigger than minVal, update maxDiff if difference is larger
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            } else {
                // Current element is smaller or equal, update minVal for future differences
                minVal = nums[i];
            }
        }

        // return maxDiff
        return maxDiff;
    }
}