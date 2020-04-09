/**
 * 
 * Leetcode #53 - https://leetcode.com/problems/maximum-subarray/
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int sumSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            if (currentSum > sumSoFar)
                sumSoFar = currentSum;
        }

        return sumSoFar;
    }
}