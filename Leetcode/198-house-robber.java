/**
 * 
 * Leetcode #198 - https://leetcode.com/problems/house-robber/
 */

//optimized solution: we only care about two elements in our array (i-1 and i-2) so simply use two variables instead - O(1) space complexity 
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int currentMax = nums[0];
        int prevMax = Math.max(currentMax, nums[1]);
        int temp;

        for (int i = 2; i < nums.length; i++) {
            temp = prevMax; // get the old previous max
            prevMax = Math.max(prevMax, currentMax + nums[i]);
            currentMax = temp; // set the old previous max as the current max
        }

        return prevMax;
    }
}

 //solution #1 - bottoms up DP - space complexity O(n) since we keep an array of size similar to the input array
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] maxes = new int[nums.length];
        maxes[0] = nums[0];
        maxes[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxes[i] = Math.max(maxes[i - 1], maxes[i - 2] + nums[i]);
        }

        return maxes[maxes.length - 1];
    }
}