# Leetcode #238 - https://leetcode.com/problems/product-of-array-except-self/

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        resultsList = []
        accum = 1
        
        for num in nums:
            resultsList.append(accum)
            accum *= num
            
        accum = nums[len(nums) - 1]
        i = len(nums) - 2
        
        while i >= 0:
            resultsList[i] *= accum
            accum *= nums[i]
            i -= 1
            
        return resultsList