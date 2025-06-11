/*
Approach:
We are given a 2D board of 'X' and 'O'. The goal is to capture all regions surrounded by 'X'.
A region is surrounded if all connected 'O's are surrounded by 'X' on all sides — not connected to any border.

To solve this:
1. Traverse all border cells (first/last row and first/last column).
2. For every border cell containing 'O', perform DFS to mark it and all connected 'O's as temporary safe using a placeholder (e.g., 'T').
3. After the DFS:
   - Flip all unmarked 'O's to 'X' (they are surrounded).
   - Flip all 'T's back to 'O' (they were connected to the border and are not surrounded).

Time Complexity: O(m * n)
- We visit each cell at most once during DFS traversal.

Space Complexity: O(m * n)
- In the worst case, DFS stack can grow up to O(m * n) if all cells are 'O'.
*/

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Perform DFS from all 'O's on the border
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0); // left border
            dfs(board, i, cols - 1); // right border
        }

        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j); // top border
            dfs(board, rows - 1, j); // bottom border
        }

        // Step 2: Flip the cells accordingly
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // 'O' not connected to border → capture
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // revert safe mark
                }
            }
        }
    }

    // DFS to mark border-connected 'O's as safe ('T')
    private void dfs(char[][] board, int i, int j) {
        // Return if out of bounds or not an 'O'
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Mark as temporarily safe

        // Explore all 4 directions
        dfs(board, i + 1, j); // down
        dfs(board, i - 1, j); // up
        dfs(board, i, j + 1); // right
        dfs(board, i, j - 1); // left
    }
}
