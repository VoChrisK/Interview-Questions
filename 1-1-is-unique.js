/* 
    Cracking the Coding Interview - #1.1 - Implement an algorithm to determine if a string has all unique characters.
*/

const isUnique = function(str) {
    let charHash = {};

    for(let i = 0; i < str.length; i++) {
        if(str.charAt(i) in charHash) return false;
        charHash[str.charAt(i)] = true;
    }

    return true;
}

console.log(isUnique("train"));
console.log(isUnique("anaconda"));
console.log(isUnique("question"));