/*
Approach:
1. Convert the number to a string for easy access to its digits.
2. Slide a window of size 'k' over the string to extract all k-length substrings.
3. Convert each substring to an integer.
4. If the integer is not zero and divides the original number evenly, increment the count.
5. Return the count.

Time Complexity: O(n * k), where n is the number of digits in the input number.
    - Substring and parse operations each take up to O(k), and we do this (n - k + 1) times.
Space Complexity: O(1) (ignoring the input string representation).
*/

class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        String str = String.valueOf(num); // Convert number to string

        for (int i = 0; i <= str.length() - k; i++) {
            String temp = str.substring(i, i + k); // Extract k-length substring
            int n = Integer.parseInt(temp); // Convert substring to integer

            if (n != 0 && num % n == 0) // Check for valid divisor and avoid division by zero
                count++;
        }

        return count; // Return total valid divisors found
    }
}
