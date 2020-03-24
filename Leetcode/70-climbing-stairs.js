/*
  @param {number} n
  @return {number}

  Leetcode #70 - https://leetcode.com/problems/climbing-stairs/
 */
var climbStairs = function (n, memo = {}) {
    if (n === 1 || n === 0) return 1;

    if (n in memo) return memo[n];

    memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    return memo[n];
};