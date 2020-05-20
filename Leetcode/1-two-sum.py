# Leetcode #1 - https://leetcode.com/problems/two-sum/

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash = {}
        for i, num in enumerate(nums):
            if num in hash:
                return [i, hash[num]]
            else:
                hash[target - num] = i