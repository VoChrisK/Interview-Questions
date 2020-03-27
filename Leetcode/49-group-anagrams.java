/**
 * Leetcode #49 - https://leetcode.com/problems/group-anagrams/
 * 
 * Time complexity - O(mlogm * n) where m is the length of the longest string in the string array
 * Space complexity - O(n)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<List<String>> newList = new ArrayList<List<String>>();
        String sortedStr;
        char[] sorted;

        for (String s : strs) {
            sorted = s.toCharArray();
            Arrays.sort(sorted);
            sortedStr = String.valueOf(sorted);

            if (!map.containsKey(sortedStr))
                map.put(sortedStr, new ArrayList<String>());

            map.get(sortedStr).add(s);
        }

        for (ArrayList<String> list : map.values()) {
            newList.add(list);
        }

        return newList;
    }
}