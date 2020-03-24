/*
    Leetcode #169 - https://leetcode.com/problems/majority-element/
*/

class Solution {
    public int majorityElement(int[] nums) {
        int counter = 1;
        int majorityElement = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                counter++;
            } else {
                counter--;
            }

            if (counter < 0) {
                majorityElement = nums[i];
                counter = 1;
            }
        }

        return majorityElement;
    }
}