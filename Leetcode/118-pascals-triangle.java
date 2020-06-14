/**
 * 
 * Leetcode #118 - https://leetcode.com/problems/pascals-triangle/
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pyramid = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return pyramid;

        pyramid.add(Arrays.asList(1));
        List<Integer> row;
        List<Integer> lastRow;

        for (int i = 1; i < numRows; i++) {
            row = new ArrayList();
            row.add(1);
            for (int j = 0; j < pyramid.size() - 1; j++) {
                lastRow = pyramid.get(pyramid.size() - 1);
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            pyramid.add(row);
        }

        return pyramid;
    }
}