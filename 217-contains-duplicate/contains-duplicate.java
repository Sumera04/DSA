/**
 * Approach:
 * - We use a HashSet to keep track of the numbers we've seen so far.
 * - As we iterate through the input array:
 *     - If a number is already in the set, we immediately return true (duplicate found).
 *     - Otherwise, we add the number to the set.
 * - If we reach the end of the array without finding any duplicates, we return false.
 *
 * Time Complexity: O(n)
 * - Where n is the number of elements in the array.
 * - We perform a single pass through the array and each set operation (add, contains) is O(1) on average.
 *
 * Space Complexity: O(n)
 * - In the worst case, we store all n elements in the HashSet (if no duplicates are present).
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Initialize a HashSet to store unique elements
        Set<Integer> set = new HashSet<Integer>();

        // Iterate through each number in the array
        for (int num : nums) {
            // If the number is already in the set, a duplicate exists
            if (set.contains(num)) {
                return true;
            }
            // Otherwise, add the number to the set
            set.add(num);
        }

        // No duplicates were found
        return false;
    }
}
