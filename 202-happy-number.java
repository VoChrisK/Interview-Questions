/*
    Leetcode #202 - https://leetcode.com/problems/happy-number/
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
                n = calcNewNumber(n);
            }
        }

        return true;
    }

    public int calcNewNumber(int n) {
        int newNum = 0;
        int digit = 0;

        while (n > 0) {
            digit = n % 10;
            newNum += Math.pow(digit, 2);
            n /= 10;
        }

        return newNum;
    }
}