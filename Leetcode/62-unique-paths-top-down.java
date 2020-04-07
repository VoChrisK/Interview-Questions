/**
 * 
 * Leetcode #62 - https://leetcode.com/problems/unique-paths/
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[n][m];
        return uniquePaths(m - 1, n - 1, paths);
    }

    public int uniquePaths(int m, int n, int[][] paths) {
        if (m == 0 && n == 0)
            return 1;
        if (m < 0 || n < 0)
            return 0;

        if (paths[n][m] != 0)
            return paths[n][m];

        paths[n][m] = uniquePaths(m - 1, n, paths) + uniquePaths(m, n - 1, paths);

        return paths[n][m];
    }
}