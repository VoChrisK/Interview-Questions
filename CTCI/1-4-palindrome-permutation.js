/* 
    Cracking the Coding Interview - Chapter 1, #1.4 - Given a string, write a function to check if it is a permutation of a palindrome. You can ignore casing and non-letter characters.
*/

const palindromePermutation = function(str) {
    let charHash = {};

    for(let i = 0; i < str.length; i++) {
        if(str.charAt(i) in charHash) {
            charHash[str[i]]++;
        } else {
            charHash[str[i]] = 1;
        }
    }

    delete charHash[" "];
    let counter = 0;

    Object.values(charHash).forEach(val => {
        if(val % 2 === 1) counter++;
    });

    return counter <= 1;
}

console.log(palindromePermutation("tact coa"));
console.log(palindromePermutation("he lll ooo eh"));