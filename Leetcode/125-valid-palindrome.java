/**
 * 
 * Leetcode #125 - https://leetcode.com/problems/valid-palindrome/
 */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        String regex = "\\W";

        while (i < j) {
            if (String.valueOf(s.charAt(i)).matches(regex)) {
                i++;
            } else if (String.valueOf(s.charAt(j)).matches(regex)) {
                j--;
            } else if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}