/*
    Cracking the Coding Interview - Chapter 1 - #1.2 - Given two strings, write a method to decide if one is a permutation of the other.
*/

const checkPermutation = function(str1, str2) {
    if(str1.length !== str2.length) return false;
    let counterHash = {};

    for(let i = 0; i < str1.length; i++) {
        if(str1[i] in counterHash) {
            counterHash[str1[i]]++;
        } else {
            counterHash[str1[i]] = 1;
        }

        if(str2[i] in counterHash) {
            counterHash[str2[i]]--;
        } else {
            counterHash[str2[i]] = -1;
        }
    }

    return Object.values(counterHash).every(ele => ele === 0);
}

console.log(checkPermutation("rbian", "brain"));
console.log(checkPermutation("cool", "kooc"));
console.log(checkPermutation("code", "cod"));