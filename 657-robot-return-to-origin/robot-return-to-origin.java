// Time Complexity: O(n), where n is the length of the input string
// Space Complexity: O(1), using constant space for x and y
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0; // initialize coordinates at origin
        char[] arr = moves.toCharArray(); // convert input string to character array

        for (char a : arr) {
            if (a == 'U') // move up increases y
                y++;
            else if (a == 'D') // move down decreases y
                y--;
            else if (a == 'R') // move right increases x
                x++;
            else if (a == 'L') // move left decreases x
                x--;
        }

        return x == 0 && y == 0; // return true if back at origin
    }
}
