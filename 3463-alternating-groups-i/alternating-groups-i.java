class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;

        // We treat the array as circular, so we iterate n times
        for (int i = 0; i < n; i++) {
            // Get 3 consecutive elements using modular arithmetic
            int a = colors[i];                      // current
            int b = colors[(i + 1) % n];            // next
            int c = colors[(i + 2) % n];            // next-next

            // Check if middle is different and ends are equal: [a, b, c] → b ≠ a and b ≠ c, and a == c
            if (b != a && b != c && a == c) {
                count++;
            }
        }

        return count;
    }
}
