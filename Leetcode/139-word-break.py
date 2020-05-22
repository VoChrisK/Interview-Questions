# Leetcode #139 - https://leetcode.com/problems/word-break/

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        isValid = []
        validIdx = []
        
        for i in range(len(s)):
            if s[0:i+1] in wordDict:
                isValid.append(True)
                validIdx.append(i+1)
            else:
                isValid.append(False)
                
            for j in validIdx:
                if s[j:i+1] in wordDict:
                    isValid[-1] = True
                    validIdx.append(i+1)
                    break
                
        return isValid[-1]