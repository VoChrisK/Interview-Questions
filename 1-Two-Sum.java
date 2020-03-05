/*
    Leetcode #1 - https://leetcode.com/problems/two-sum/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(hash.containsKey(key)) {
                int[] twoSums = {hash.get(key), i};
                return twoSums;
            }
            else {
                hash.put(target - key, i);
            }
            
        }
        
        return null;
    }
}