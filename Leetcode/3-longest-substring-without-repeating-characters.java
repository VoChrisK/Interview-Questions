/**
 * 
 * Leetcode #3 - https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int slow = 0;
        int fast = 0;
        int longest = 0;

        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                if (fast - slow > longest)
                    longest = fast - slow;

                while (set.contains(s.charAt(fast)) && slow < fast) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
            }

            set.add(s.charAt(fast));
            fast++;
        }

        if (fast - slow > longest)
            longest = fast - slow;
        return longest;
    }
}