/**
 * 
 * Leetcode #119 - https://leetcode.com/problems/pascals-triangle-ii/
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if (rowIndex < 1)
            return list;
        list.add(1);

        int temp;
        int res;

        for (int i = 1; i < rowIndex; i++) {
            temp = 1;
            for (int j = 0; j < i; j++) {
                res = temp + list.get(j + 1);
                temp = list.get(j + 1);
                list.set(j + 1, res);
            }
            list.add(1);
        }

        return list;
    }
}