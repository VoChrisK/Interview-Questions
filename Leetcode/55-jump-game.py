# Leetcode #55 - https://leetcode.com/problems/jump-game/

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        i = 0
        
        while i < len(nums):
            j = nums[i] - 1
            
            while j >= 0 and i < len(nums) - 1:
                i += 1
                
                if nums[i] > j:
                    j = nums[i]
                    
                j -= 1
                
            if nums[i] == 0 and i < len(nums) - 1:
                return False
            
            i += 1
                
        return True