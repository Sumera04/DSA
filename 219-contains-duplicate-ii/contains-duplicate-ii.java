/**
 * - Use a sliding window of size at most k implemented via a HashSet.
 * - As we iterate through the array:
 *    - Check if the current element already exists in the set.
 *    - If it does, return true (duplicate found within range k).
 *    - If not, add it to the set.
 *    - If the set size exceeds k, remove the oldest element (nums[i - k]).
 *
 * Time Complexity: O(n)      // Each element is added and removed at most once
 * Space Complexity: O(k)     // At most k elements are stored in the set
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // A HashSet to store up to k recent elements for duplicate checking
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If nums[i] already exists in the set, it's a nearby duplicate
            if (!set.add(nums[i]))
                return true;

            // Maintain a sliding window of size k
            if (i >= k)
                set.remove(nums[i - k]);
        }
        // No nearby duplicates found
        return false;
    }
}