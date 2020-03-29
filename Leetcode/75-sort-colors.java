/**
 * 
 * Leetcode #75 - https://leetcode.com/problems/sort-colors/
 */

class Solution {
    public void sortColors(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == 0 && first < i)
                swap(nums, first++, i);
            else if (nums[i] == 2 && last > i)
                swap(nums, last--, i);
            else
                i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
}