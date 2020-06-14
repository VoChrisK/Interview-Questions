/**
 * 
 * Leetcode #171 - https://leetcode.com/problems/excel-sheet-column-number/
 */

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int current;

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(s.length() - i - 1) - 'A' + 1;
            res += current * Math.pow(26, i);
        }

        return res;
    }
}