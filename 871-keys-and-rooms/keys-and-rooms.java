// Time Complexity: O(n + k), where n is the number of rooms and k is the total number of keys across all rooms
// Space Complexity: O(n), for the visited array and recursion stack in the worst case
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()]; // track visited rooms
        dfs(rooms, visited, 0); // start DFS from room 0
        
        for (boolean b : visited) {
            if (!b) // if any room hasn't been visited, return false
                return false;
        }

        return true; // all rooms visited
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int source) {
        visited[source] = true; // mark current room as visited
        for (int r : rooms.get(source)) { // iterate over keys in current room
            if (!visited[r]) // visit unvisited rooms
                dfs(rooms, visited, r);
        }
    }
}
