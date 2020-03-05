/*
 @param {number[]} prices
  @return {number} 

  Leetcode #121 - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/


var maxProfit = function (prices) {
    if (prices.length < 1) return 0;
    let maxSoFar = 0;
    let currentMax = 0;
    let buy = prices[0];

    for (let i = 1; i < prices.length; i++) {
        currentMax = prices[i] - buy;
        if (currentMax < 0) {
            currentMax = 0;
            buy = prices[i];
        }

        if (currentMax > maxSoFar) {
            maxSoFar = currentMax;
        }
    }

    return maxSoFar;
};