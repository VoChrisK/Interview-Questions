/*
    Leetcode #189 - https://leetcode.com/problems/rotate-array/
*/

class Solution {
    public void rotate(int[] nums, int k) {
        rotateArray(nums, 0, nums.length - 1);
        rotateArray(nums, 0, (k % nums.length) - 1);
        rotateArray(nums, (k % nums.length), nums.length - 1);
    }

    public void rotateArray(int[] nums, int i, int j) {
        while (i <= j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}