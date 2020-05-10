/**
 * @param {number[]} nums
 * @return {number}
 * 
 * Leetcode #724 - https://leetcode.com/problems/find-pivot-index/
 */
var pivotIndex = function (nums) {
    if (nums.length < 3) return -1;

    let sum = nums.reduce((acc, ele) => acc + ele, 0);
    let otherSum = 0;

    if (sum - nums[0] === 0) return 0;

    for (let i = 0; i < nums.length - 1; i++) {
        otherSum += nums[i];
        sum -= nums[i];
        if (otherSum === sum - nums[i + 1]) return i + 1;
    }

    return -1;
};