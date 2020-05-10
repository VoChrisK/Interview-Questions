/**
 * @param {number[]} prices
 * @return {number}
 * 
 * Leetcode #122 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
var maxProfit = function (prices) {
    if (prices.length < 2) return 0;
    let maxProfit = 0;
    let profitSoFar = 0;
    let index = 0;

    for (let i = 1; i < prices.length; i++) {
        if (prices[i] - prices[index] < profitSoFar) {
            index = i;
            maxProfit += profitSoFar;
            profitSoFar = 0;
        } else {
            profitSoFar = prices[i] - prices[index];
        }
    }

    maxProfit += profitSoFar;
    return maxProfit;
};