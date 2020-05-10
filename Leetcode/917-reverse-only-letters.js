/**
 * @param {string} S
 * @return {string}
 * 
 * Leetcode #917 - https://leetcode.com/problems/reverse-only-letters/
 */
var reverseOnlyLetters = function (S) {
    const regex = new RegExp('[a-z]', 'i');
    let newString = S.split("");
    let i = 0;
    let j = S.length - 1;

    while (i < j) {
        if (!regex.test(S.charAt(i))) {
            i++;
        } else if (!regex.test(S.charAt(j))) {
            j--;
        } else {
            [newString[i], newString[j]] = [newString[j], newString[i]];
            i++;
            j--;
        }
    }

    return newString.join("");
};