/**
 * 
 * Leetcode #17 - https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

 /**
  * 
  * Solution #1: 4/6/2020
  */

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] buttons = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> list = new ArrayList<String>();
        StringBuilder build = new StringBuilder();
        int count = 0;

        if (digits.equals(""))
            return list;

        int index = digits.charAt(0) - '0';
        for (int i = 0; i < buttons[index].length(); i++) {
            list.add(String.valueOf(buttons[index].charAt(i)));
        }

        for (int i = count + 1; i < digits.length(); i++) {
            index = digits.charAt(i) - '0';
            int size = list.size();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < buttons[index].length(); k++) {
                    build.setLength(0);
                    build.append(list.get(0));
                    build.append(buttons[index].charAt(k));
                    list.add(build.toString());
                }
                list.remove(0);
            }
        }

        return list;
    }
}

/**
 * 
 * Solution #2: 8 months ago, starting 4/6/2020
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] buttons = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> list = new ArrayList<String>();
        StringBuilder build = new StringBuilder();
        int count = 0;

        if (digits.equals(""))
            return list;

        int index = digits.charAt(0) - '0';
        for (int i = 0; i < buttons[index].length(); i++) {
            list.add(String.valueOf(buttons[index].charAt(i)));
        }

        for (int i = count + 1; i < digits.length(); i++) {
            index = digits.charAt(i) - '0';
            int size = list.size();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < buttons[index].length(); k++) {
                    build.setLength(0);
                    build.append(list.get(0));
                    build.append(buttons[index].charAt(k));
                    list.add(build.toString());
                }
                list.remove(0);
            }
        }

        return list;
    }
}