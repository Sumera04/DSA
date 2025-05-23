/**
 * Problem: Longest Harmonious Subsequence (LHS)
 *
 * Approach:
 * - Use a HashMap to count the frequency of each number in the array.
 * - For each unique number `num`, check if either `num + 1` or `num - 1` exists in the map.
 * - If yes, the harmonious subsequence can include both `num` and `num ± 1`.
 * - Update the maximum length found so far using the sum of their frequencies.
 *
 * Note:
 * - We only need to check keys in the map (not all elements in the array),
 *   to avoid redundant calculations.
 *
 * Time Complexity: O(n)
 * - One pass to build the map, and another to iterate over keys.
 *
 * Space Complexity: O(n)
 * - Storing frequencies of each element in the map.
 */
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Iterate over the unique keys
        for (int num : map.keySet()) {
            // Check for adjacent value (num + 1)
            if (map.containsKey(num + 1)) {
                int currentLength = map.get(num) + map.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
