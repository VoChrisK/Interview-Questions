/**
 * 
 * Leetcode #448 - https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<Integer>();
        int index;
        int size = 0;

        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missing.add(i + 1);
        }

        return missing;
    }
}