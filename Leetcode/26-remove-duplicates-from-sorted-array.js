/**
 * @param {number[]} nums
 * @return {number}
 * 
 * Leetcode #26 - https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
var removeDuplicates = function (nums) {
    if (nums.length === 0) return 0;
    let count = 1;
    let index = 1;

    for (let i = 0; i < nums.length - 1; i++) {
        if (nums[i] !== nums[i + 1]) {
            nums[index] = nums[i + 1];
            index++;
            count++;
        }
    }

    return count;
};

/*
    [
        1,2,3,4,5
    ]
*/