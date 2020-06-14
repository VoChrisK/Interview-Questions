/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 * 
 * Leetcode #27 - https://leetcode.com/problems/remove-element/
 */
var removeElement = function (nums, val) {
    let index = 0;
    let count = 0;

    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) {
            swap(nums, index, i);
            index++;
            count++;
        }
    }

    return count;
};

var swap = function (nums, i, j) {
    let temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
};