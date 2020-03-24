/*
 @param {number[]} nums
 @return {void} Do not return anything, modify nums in-place instead.

 Leetcode #283 - https://leetcode.com/problems/move-zeroes/
 */
var moveZeroes = function (nums) {
    let numZeroes = 0;

    for (let i = 0; i < nums.length; i++) {
        nums[i - numZeroes] = nums[i];
        if (nums[i] === 0) numZeroes++;
        if (i - numZeroes < i) nums[i] = 0;
    }
};