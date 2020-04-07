/**
 * 
 * Leetcode #62 - https://leetcode.com/problems/unique-paths/
 */

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;

        int[][] paths = new int[n][m];
        paths[0][1] = 1;
        paths[1][0] = 1;

        for (int i = 0; i < m; i++) {
            paths[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            paths[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                paths[i][j] = paths[i][j - 1] + paths[i - 1][j];
            }
        }

        return paths[n - 1][m - 1];
    }
}