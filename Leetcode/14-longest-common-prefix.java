/**
 * 
 * Leetcode #14 - https://leetcode.com/problems/longest-common-prefix/
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";
        int index = 0;
        int min = Integer.MAX_VALUE;
        String prefix = "";
        char letter;

        for (String s : strs) {
            if (s.length() < min)
                min = s.length();
        }

        while (index < min) {
            letter = strs[0].charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (letter != strs[i].charAt(index))
                    return prefix;
            }

            prefix += letter;
            index++;
        }

        return prefix;
    }
}