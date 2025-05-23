/**
 * Approach:
 * - Sort the array to group the same numbers and bring adjacent numbers together.
 * - Use two pointers to keep track of a window where the difference between max and min is 1.
 * - If the difference is more than 1, shrink the window.
 * - When the difference is exactly 1, update maxLength with window size.
 *
 * Time Complexity: O(n log n) - due to sorting
 * Space Complexity: O(1) - no extra space used
 */
class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            // Shrink window if difference is more than 1
            while (nums[end] - nums[start] > 1) {
                start++;
            }

            // If exactly 1, update max length
            if (nums[end] - nums[start] == 1) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;
    }
}
