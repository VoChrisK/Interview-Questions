# Leetcode #171 - https://leetcode.com/problems/excel-sheet-column-number/

class Solution:
    def titleToNumber(self, s: str) -> int:
        res = 0
        
        for i in range(len(s)):
            res += math.floor((ord(s[-(i+1)]) - 65 + 1) * math.pow(26, i))
            
        return res