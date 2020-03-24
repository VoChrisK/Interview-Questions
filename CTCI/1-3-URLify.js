/* 
    Cracking the Coding Interview - Chapter 1 - #1.3 - Write a method to replace all spaces with '%20'.
    Note: The string is stored in a character array in order to solve the problem in-place.
*/

const URLify = function(str, trueLength) {
    let keepTrack = str.length - 1;
    trueLength -= 1;

    while(trueLength >= 0) {
        if(str[trueLength] === ' ') {
            str[keepTrack] = '0';
            str[keepTrack-1] = '2';
            str[keepTrack-2] = '%';
            keepTrack -= 3;
        } else {
            str[keepTrack] = str[trueLength];
            keepTrack--;
        }
        trueLength--;
    }

    return str;
}

let str = new Array(17);
str[0] = "M";
str[1] = "r";
str[2] = " ";
str[3] = "J";
str[4] = "o";
str[5] = "h";
str[6] = "n";
str[7] = " ";
str[8] = "S";
str[9] = "m";
str[10] = "i";
str[11] = "t";
str[12] = "h";
str[13] = " ";
str[14] = " ";
str[15] = " ";
str[16] = " ";

console.log(URLify(str, 13).join(""));