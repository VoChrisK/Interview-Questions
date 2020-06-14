/**
 * @param {number} n
 * @return {string[]}
 * 
 * Leetcode #22 - https://leetcode.com/problems/generate-parentheses/
 */
var generateParenthesis = function (n) {
    let parentheses = [];
    findCombinations(n, 0, 0, "", parentheses);
    return parentheses;
};

var findCombinations = function (n, left, right, paren, parentheses) {
    if (right > left || left > n) {
        return;
    }

    if (left + right === 2 * n) {
        parentheses.push(paren);
        return;
    }

    findCombinations(n, left + 1, right, paren + '(', parentheses);
    findCombinations(n, left, right + 1, paren + ')', parentheses);
};