/*
Approach:
We are given a 2D board containing 'X' (battleship part) and '.' (empty water).
Each battleship is made up of contiguous 'X's aligned either horizontally or vertically — no diagonals.
The goal is to count how many **distinct battleships** are on the board.

We use DFS to explore each group of connected 'X's and mark them as visited (by turning them into '.').
Each DFS traversal from an unvisited 'X' represents one full battleship.

Time Complexity: O(m * n)
- We visit each cell once at most.

Space Complexity: O(m * n) (worst-case recursion stack for DFS)
*/

class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Found an unvisited part of a ship
                if (board[i][j] == 'X') {
                    dfs(board, i, j); // Mark entire ship
                    count++; // Increment ship count
                }
            }
        }

        return count;
    }

    // DFS to mark all connected 'X's (part of the same ship)
    private void dfs(char[][] board, int i, int j) {
        // Boundary and visited check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X')
            return;

        board[i][j] = '.'; // Mark as visited

        // Explore in all four directions
        dfs(board, i + 1, j); // down
        dfs(board, i - 1, j); // up
        dfs(board, i, j + 1); // right
        dfs(board, i, j - 1); // left
    }
}