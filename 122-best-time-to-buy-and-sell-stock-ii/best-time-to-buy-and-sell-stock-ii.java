/* Approach:
 * - This problem allows **multiple transactions** (buy and sell as many times as you like),
 *   but you must sell before buying again.
 * - Use a greedy approach:
 *     - Traverse the array from index 1.
 *     - If today's price is greater than yesterday's (i.e., profit opportunity),
 *       add the profit to totalProfit.
 *     - Update minVal to current price regardless, since a new buying point starts each day.
 * - This way, we sum all the positive price differences, which simulates buying low and selling high repeatedly.
 *
 * Time Complexity: O(n) — Single pass through the array
 * Space Complexity: O(1) — Constant extra space used
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minVal = prices[0];      // Current buying price
        int totalProfit = 0;         // Accumulated profit

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minVal) {
                // Profit opportunity: buy at minVal, sell at current price
                totalProfit += prices[i] - minVal;
                // Update minVal to current price for next transaction
                minVal = prices[i];
            } else {
                // New lower price found — update minVal to buy cheaper
                minVal = prices[i];
            }
        }

        return totalProfit;
    }
}
