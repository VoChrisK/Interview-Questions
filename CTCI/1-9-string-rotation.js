/*
    Cracking the Coding Interview - Chapter 1, #1.9 - Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
    only one call to includes (e.g., "waterbottle" is a rotation of "erbottlewat")
*/

const stringRotation = function(str1, str2) {
    return str2.concat(str2).includes(str1);
};

console.log(stringRotation("waterbottle", "erbottlewat"));
console.log(stringRotation("waterbottle", "erbottlewa"));