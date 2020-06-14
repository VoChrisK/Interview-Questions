/*
  @param {number} x
  @return {boolean}

  Leetcode #9 - https://leetcode.com/problems/palindrome-number/
 */

// solution #2 (June 2020):
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
    if (x < 0) return false;

    let reverse = 0;
    let copy = x;

    while (copy > 0) {
        let digit = copy % 10;
        reverse = (reverse * 10) + digit;
        copy = Math.floor(copy / 10);
    }

    return reverse === x;
};

// solution #1 (March 2020)
var isPalindrome = function (x) {
    if (x < 0) return false;
    let arr = [];
    let y = x;

    while (y > 0) {
        arr.push(y % 10);
        y = Math.floor(y / 10);
    }

    for (let i = arr.length - 1; i >= 0; i--) {
        if (x % 10 !== arr[i]) return false;
        x = Math.floor(x / 10);
    }

    return true;
};

