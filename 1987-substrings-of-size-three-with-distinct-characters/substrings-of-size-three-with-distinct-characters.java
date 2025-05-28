/*
Approach:
We iterate over the input string and use a sliding window approach to check all possible substrings of length 3.
We use a HashSet to track the characters in the current window.
If we encounter a duplicate or the size of the set reaches 3, we check whether it's a valid "good" substring (all unique characters).
If it's good, we increment the count and slide the window accordingly.

Time Complexity: O(n), where n is the length of the string. In the worst case, each character is visited once.
Space Complexity: O(1), as the HashSet stores at most 3 characters at any time.
*/

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0; // To store the count of good substrings
        int start = 0; // Start index of the current window

        Set<Character> set = new HashSet<>(); // Set to track unique characters in the window
        char[] arr = s.toCharArray(); // Convert the string to a char array for faster access

        for (int i = 0; i < arr.length; i++) {
            // If set already has 3 characters or contains a duplicate
            if (set.size() == 3 || set.contains(arr[i])) {
                set.clear(); // Clear the set to reset the window
                start++; // Move the start index of the window
                i = start - 1; // Reset the loop index to start - 1 (i will be incremented in next iteration)
                continue; // Skip to the next iteration
            }

            set.add(arr[i]); // Add the current character to the set

            if (set.size() == 3) {
                count++; // If the set size is 3, it means we have a good substring
            }
        }

        return count; // Return the total number of good substrings
    }
}
