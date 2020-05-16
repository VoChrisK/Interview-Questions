/**
 * 
 * Leetcode #200 - https://leetcode.com/problems/number-of-islands/
 */

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    searchMoreLand(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    // depth first search
    public void searchMoreLand(char[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        searchMoreLand(grid, i + 1, j);
        searchMoreLand(grid, i - 1, j);
        searchMoreLand(grid, i, j + 1);
        searchMoreLand(grid, i, j - 1);
    }
}