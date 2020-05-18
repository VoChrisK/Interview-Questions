/**
 * 
 * Leetcode #441 - https://leetcode.com/problems/arranging-coins/
 */

class Solution {
    public int arrangeCoins(int n) {
        Long value = (long) n * 2;
        int solution = (int) Math.floor(Math.sqrt(value + 0.25) - 0.5);
        return solution;
    }
}

/*
 * (x(x + 1)) / 2 <= n 
 * x(x + 1) <= 2n 
 * x^2 + x <= 2n 
 * x^2 + x + 1/4 - 1/4 <= 2n
 * x^2 + x + 1/4 <= 2n + 1/4 
 * (x + 1/2)^2 <= 2n + 1/4 
 * x + 1/2 <= sqrt(2n + 1/4) 
 * x <= sqrt(2n + 1/4) - 1/2
 */