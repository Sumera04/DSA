class Solution {
    /*
     * Approach:
     * - Use a greedy one-pass strategy to maximize profit.
     * - Initialize minVal to the first price in the array.
     * - Iterate through the prices:
     *     - If current price > minVal → possible profit → update maxProfit.
     *     - If current price < minVal → update minVal to the lower price.
     * - Return the maxProfit found.
     *
     * Time Complexity: O(n) - traverse the array once
     * Space Complexity: O(1) - uses constant extra space
     */

    public int maxProfit(int[] prices) {
        int minVal = prices[0];  // Minimum price seen so far (potential buy price)
        int maxProfit = 0;       // Maximum profit found so far

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minVal) {
                // Selling today would give a profit; check if it's the best so far
                maxProfit = Math.max(maxProfit, prices[i] - minVal);
            } else {
                // Found a lower price to potentially buy at in future
                minVal = prices[i];
            }
        }

        return maxProfit; // Return the best profit found
    }
}