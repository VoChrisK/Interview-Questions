/**
 * 
 * Leetcode #66 - https://leetcode.com/problems/plus-one/
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int res = 0;

        for (int i = digits.length - 1; i >= 0 && carry == 1; i--) {
            res = digits[i] + carry;
            carry = res == 10 ? 1 : 0;
            digits[i] = res == 10 ? 0 : res;
        }

        if (carry == 1) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newArr[i + 1] = digits[i];
            }
            return newArr;
        }

        return digits;
    }
}