/*
    Leetcode #205 - https://leetcode.com/problems/isomorphic-strings/
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map2.containsKey(t.charAt(i))) {
                if (map2.get(t.charAt(i)) != s.charAt(i))
                    return false;
            } else {
                map2.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}