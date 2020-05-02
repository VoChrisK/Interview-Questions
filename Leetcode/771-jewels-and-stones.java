/**
 * 
 * Leetcode #771 - https://leetcode.com/problems/jewels-and-stones/
 */

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<Character>();
        int counter = 0;

        for (char c : J.toCharArray()) {
            set.add(c);
        }

        for (char c : S.toCharArray()) {
            if (set.contains(c))
                counter++;
        }

        return counter;
    }
}