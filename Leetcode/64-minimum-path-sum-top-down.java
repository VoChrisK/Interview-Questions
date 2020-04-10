/**
 * 
 * Leetcode #64 - https://leetcode.com/problems/minimum-path-sum/
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] paths = new int[grid.length][grid[0].length];
        for (int[] rows : paths) {
            Arrays.fill(rows, -1);
        }

        return minPathSum(grid, paths, grid.length - 1, grid[0].length - 1);
    }

    public int minPathSum(int[][] grid, int[][] paths, int i, int j) {
        if (i == 0 && j == 0)
            return grid[0][0];
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if (paths[i][j] != -1)
            return paths[i][j];

        paths[i][j] = grid[i][j] + Math.min(minPathSum(grid, paths, i - 1, j), minPathSum(grid, paths, i, j - 1));

        return paths[i][j];
    }
}