/*
 * Approach:
 * - Use a HashMap to store previously visited numbers and their indices.
 * - For each number, calculate its complement (target - current number).
 * - If the complement is already in the map, return its index and the current index.
 * - Otherwise, store the current number and index in the map.
 * - This ensures we find the pair in one pass (O(n) time).
 *
 * Time Complexity: O(n) – We traverse the array once.
 * Space Complexity: O(n) – HashMap stores up to n elements in the worst case.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Traverse the array once
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];  // Compute the complement

            // Check if complement already exists in the map
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};  // Return indices of the pair
            } else {
                map.put(nums[i], i);  // Store current number with its index
            }
        }

        // Return empty array if no solution found (per problem guarantee, this line won't be hit)
        return new int[]{};
    }
}