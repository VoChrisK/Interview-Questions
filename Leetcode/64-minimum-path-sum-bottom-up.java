/**
 * 
 * Leetcode #64 - https://leetcode.com/problems/minimum-path-sum/
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int[] paths = new int[grid[0].length];
        paths[0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            paths[i] = paths[i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            paths[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                paths[j] = grid[i][j] + Math.min(paths[j - 1], paths[j]);
            }
        }

        return paths[paths.length - 1];
    }
}