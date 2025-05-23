/**
 * Approach:
 * - Sort the array first. If there are any duplicates, they will appear consecutively.
 * - After sorting, iterate through the array and compare each element to its previous one.
 *   - If any two consecutive elements are equal, return true (duplicate found).
 *   - If the loop completes without finding duplicates, return false.
 *
 * Time Complexity: O(n log n)
 * - The sorting step takes O(n log n) time.
 * - The linear scan afterward takes O(n) time.
 * - Total time is dominated by the sorting step: O(n log n).
 *
 * Space Complexity: O(1) if sorting in-place (e.g., using Arrays.sort).
 * - If a non-in-place sorting algorithm is used internally, the space complexity could be O(n).
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Sort the array to bring duplicates next to each other
        Arrays.sort(nums);

        // Check for any two consecutive elements being equal
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true; // Duplicate found
            }
        }

        // No duplicates found
        return false;
    }
}