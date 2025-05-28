/*
Approach:
We want the minimum number of white blocks ('W') in any window of size 'k'.
Each 'W' in a window must be recolored to 'B', so fewer 'W's means fewer recolors.
We use a sliding window of size k:
- Count how many 'W' blocks are in the window.
- Update the answer as we slide the window forward.

Time Complexity: O(n), where n = length of the blocks string.
Space Complexity: O(1), using only variables.
*/
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE; // Minimum number of recolors needed
        int count = 0; // Number of 'W' blocks in the current window
        int start = 0; // Start index of the window

        for (int end = 0; end < blocks.length(); end++) {
            // Add right-end character to the window
            if (blocks.charAt(end) == 'W')
                count++;

            // When window size reaches k
            if (end - start + 1 == k) {
                ans = Math.min(ans, count); // Update minimum

                // Slide the window: remove left-end character
                if (blocks.charAt(start) == 'W')
                    count--;

                start++; // Move window forward
            }
        }
        return ans;
    }
}