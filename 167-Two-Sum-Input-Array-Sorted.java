/*
    Leetcode #167 - https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (j > i) {
            if (numbers[i] + numbers[j] == target) {
                int[] indices = { i + 1, j + 1 };
                return indices;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return null;
    }
}