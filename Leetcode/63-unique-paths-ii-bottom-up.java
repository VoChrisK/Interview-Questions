/**
 * 
 * Leetcode #63 - https://leetcode.com/problems/unique-paths-ii/
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;

        int[] currentRow = new int[obstacleGrid[0].length];

        boolean obstacle = false;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1)
                obstacle = true;
            currentRow[i] = obstacle ? 0 : 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            currentRow[0] = obstacleGrid[i][0] == 1 ? 0 : currentRow[0];
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                currentRow[j] = obstacleGrid[i][j] == 1 ? 0 : currentRow[j] + currentRow[j - 1];
            }
        }

        return currentRow[currentRow.length - 1];
    }
}