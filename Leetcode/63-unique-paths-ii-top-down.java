/**
 * 
 * Leetcode #63 - https://leetcode.com/problems/unique-paths-ii/
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        return uniquePathsWithObstacles(obstacleGrid, paths, m - 1, n - 1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int[][] paths, int m, int n) {
        if ((m < 0 || n < 0) || obstacleGrid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;

        if (paths[m][n] != 0)
            return paths[m][n];

        paths[m][n] = uniquePathsWithObstacles(obstacleGrid, paths, m - 1, n)
                + uniquePathsWithObstacles(obstacleGrid, paths, m, n - 1);

        return paths[m][n];
    }
}