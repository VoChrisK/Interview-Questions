/*
 * @param {string} s
 * @return {string}
 * Leetcode #345 - https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
var reverseVowels = function (s) {
    let charArray = s.split("");
    let vowels = "aeiouAEIOU";
    let temp;
    let i = 0;
    let j = charArray.length - 1;

    while (i < j) {
        if (vowels.includes(charArray[i]) && vowels.includes(charArray[j])) {
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }

        if (!vowels.includes(charArray[i])) {
            i++;
        }

        if (!vowels.includes(charArray[j])) {
            j--;
        }
    }

    return charArray.join("");
};