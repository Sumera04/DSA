class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0, n = colors.length;

        for (int i = 0; i < n; i++) {
            int prev = colors[(i - 1 + n) % n];
            int next = colors[(i + 1) % n];

            // Check if current tile is different from both neighbors
            if (colors[i] != prev && colors[i] != next) {
                count++;
            }
        }

        return count;
    }
}
