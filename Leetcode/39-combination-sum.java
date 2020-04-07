/**
 * 
 * Leetcode #39 - https://leetcode.com/problems/combination-sum/
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        findCombinations(candidates, target, list, new ArrayList(), 0);
        return list;
    }

    public void findCombinations(int[] candidates, int target, List<List<Integer>> sums, List<Integer> sum, int start) {
        if (target <= 0) {
            if (target == 0)
                sums.add(new ArrayList(sum));
            return;
        }

        for (int idx = start; idx < candidates.length; idx++) {
            sum.add(candidates[idx]);
            findCombinations(candidates, target - candidates[idx], sums, sum, idx);
            sum.remove(sum.size() - 1);
        }
    }
}