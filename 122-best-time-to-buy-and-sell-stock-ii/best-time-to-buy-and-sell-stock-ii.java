/* 
 * Approach:
 * - This is a greedy solution.
 * - You are allowed to buy and sell multiple times (but must sell before buying again).
 * - The idea is to capture **all upward price movements**.
 * - Traverse the prices array from day 1:
 *     - If today's price is greater than yesterday's, we "buy yesterday and sell today".
 *     - Accumulate that profit.
 * - This guarantees capturing all local profits.
 *
 * Time Complexity: O(n) – Single traversal of the array
 * Space Complexity: O(1) – No extra space used
 */
class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        // Loop through prices starting from day 1
        for (int i = 1; i < prices.length; i++) {
            // If price increased from previous day, add the profit
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit; // Total profit from all profitable transactions
    }
}
