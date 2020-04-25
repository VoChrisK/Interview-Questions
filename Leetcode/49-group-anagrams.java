/**
 * Leetcode #49 - https://leetcode.com/problems/group-anagrams/
 * 
 * Time complexity - O(mlogm * n) where m is the length of the longest string in the string array
 * Space complexity - O(n)
 */

// solution 2: mapping indices:

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<List<String>> groups = new ArrayList<List<String>>();
        int counter = 0;
        char[] charArr;
        String sortedWord;

        for (String str : strs) {
            charArr = str.toCharArray();
            Arrays.sort(charArr);
            sortedWord = String.valueOf(charArr);

            if (map.containsKey(sortedWord)) {
                groups.get(map.get(sortedWord)).add(str);
            } else {
                map.put(sortedWord, counter);
                groups.add(new ArrayList<String>());
                groups.get(counter).add(str);
                counter++;
            }
        }

        return groups;
    }
}

// solution 1 (completed one month ago):

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