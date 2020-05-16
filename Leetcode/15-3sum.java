/**
 * 
 * Leetcode #15 - https://leetcode.com/problems/3sum/
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1])
                continue;
            twoSums(nums, i + 1, 0 - nums[i], triplets);
        }

        return triplets;
    }

    public void twoSums(int[] nums, int index, int target, List<List<Integer>> triplets) {
        int i = index;
        int j = nums.length - 1;
        List<Integer> triplet;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                triplet = new ArrayList<Integer>();
                triplet.add(nums[i]);
                triplet.add(nums[j]);
                triplet.add(nums[index - 1]);
                triplets.add(triplet);
                i++;
                j--;
                while (nums[i] == nums[i - 1] && i < j)
                    i++;
                while (nums[j] == nums[j + 1] && i < j)
                    j--;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
    }
}