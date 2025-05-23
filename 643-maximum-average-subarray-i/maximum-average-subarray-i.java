/**
 * Approach:
 * - Use a sliding window of size `k` to find the subarray with the maximum average.
 * - Start by computing the sum of the first `k` elements.
 * - Then slide the window forward one element at a time:
 *     - Subtract the element going out of the window
 *     - Add the new element coming into the window
 *     - Update the result if the new average is higher
 *
 * Time Complexity: O(n)
 * - Traverse the array only once.
 *
 * Space Complexity: O(1)
 * - Constant extra space used.
 */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;

        // Compute sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double result = sum;

        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Slide the window
            result = Math.max(result, sum);
        }

        return result / k;
    }
}
