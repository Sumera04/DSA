/*
Approach:
We iterate through the string using a fixed-size sliding window of length 3.
For each window (i, i+1, i+2), we directly compare the three characters.
If all three characters are distinct, we increment the count.
This avoids using extra data structures like a HashSet, making the solution more efficient.

Time Complexity: O(n), where n is the length of the string.
Space Complexity: O(1), as we use only a few integer/char variables.
*/

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0; // Initialize the counter for good substrings
        char[] arr = s.toCharArray(); // Convert the string to a character array for fast access

        // Loop until the third-last character to avoid index out of bounds
        for (int i = 0; i < arr.length - 2; i++) {
            char a = arr[i];       // First character in the window
            char b = arr[i + 1];   // Second character in the window
            char c = arr[i + 2];   // Third character in the window

            // Check if all three characters are distinct
            if (a != b && b != c && c != a)
                count++; // It's a good substring, increment count
        }

        return count; // Return the total number of good substrings
    }
}