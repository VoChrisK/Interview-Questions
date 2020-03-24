/*
    Leetcode #35 - https://leetcode.com/problems/search-insert-position/
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    public int binarySearch(int[] nums, int target, int low, int high) {
        if(low > high) return low;

        int mid = (low + high) / 2;
        
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarySearch(nums, target, low, mid-1);
        } else {
            return binarySearch(nums, target, mid+1, high);
        }
    }
}