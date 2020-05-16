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

    // breadth first search
    public void searchMoreLand(char[][] grid, int i, int j) {
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(i);
        pair.add(j);
        queue.add(pair);

        while (!queue.isEmpty()) {
            pair = queue.poll();
            i = pair.get(0);
            j = pair.get(1);

            if (checkBounds(grid, i + 1, j))
                queue.add(createPairs(grid, i + 1, j));
            if (checkBounds(grid, i - 1, j))
                queue.add(createPairs(grid, i - 1, j));
            if (checkBounds(grid, i, j + 1))
                queue.add(createPairs(grid, i, j + 1));
            if (checkBounds(grid, i, j - 1))
                queue.add(createPairs(grid, i, j - 1));
        }
    }

    public boolean checkBounds(char[][] grid, int i, int j) {
        return (i >= 0 && i < grid.length) && (j >= 0 && j < grid[0].length) && grid[i][j] != '0';
    }

    public ArrayList<Integer> createPairs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        ArrayList<Integer> pair = new ArrayList<Integer>();
        pair.add(i);
        pair.add(j);
        return pair;
    }
}