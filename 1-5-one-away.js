/* 
    Cracking the Coding Interview - Chapter 1, #1.5 - There are three types of edits that can be performed on strings: insert
    a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit
    (or zero edits) away.
*/

const oneAway = function(str1, str2) {
    if(Math.abs(str1.length - str2.length) > 1) return false;

    let charHash = {};

    for(const x of str1) {
        if(x in charHash) {
            charHash[x]++;
        } else {
            charHash[x] = 1;
        }
    }

    for(const x of str2) {
        if (x in charHash) {
            charHash[x]--;
        } else {
            charHash[x] = -1;
        }
    }
    
    let count = 0;
    Object.values(charHash).forEach(val => {
        if(val !== 0) count++;
    });

    return count <= 2;
}

console.log(oneAway("pale", "ple"));
console.log(oneAway("pales", "pale"));
console.log(oneAway("pale", "bale"));
console.log(oneAway("pale", "bake"));
console.log(oneAway("pale", "ble"));