/**
 * Approach:
 * - The goal is to find the "town judge" among n people.
 * - The town judge must:
 *     1. Trust no one.
 *     2. Be trusted by exactly n - 1 people.
 *
 * - We use:
 *   - An adjacency list to store who each person trusts.
 *   - An array `trustCount` to count how many people trust each person.
 *
 * - For each trust pair [a, b]:
 *   - Person `a` trusts person `b` → add `b` to adjList[a]
 *   - Increment `trustCount[b]` (since `b` is trusted by `a`)
 *
 * - Finally, loop through each person:
 *   - If they trust no one (adjList[i].size() == 0)
 *   - And they are trusted by n - 1 people → they are the judge
 *
 * Time Complexity: O(t + n), where t = number of trust relationships
 * Space Complexity: O(n + t), for the adjacency list and trust count array
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        // Create adjacency list: adjList[i] stores people that i trusts
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        // trustCount[i] = number of people who trust person i
        int[] trustCount = new int[n + 1];

        // Populate adjList and trustCount from trust relationships
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            adjList.get(a).add(b); // person a trusts person b
            trustCount[b]++; // person b is trusted by person a
        }

        // Check each person to see if they are the judge
        for (int i = 1; i <= n; i++) {
            if (adjList.get(i).size() == 0 && trustCount[i] == n - 1) {
                return i; // Found the judge
            }
        }

        return -1; // No judge found
    }
}
