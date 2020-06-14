// Partner: Carina

// Word Count Engine
// Implement a document scanning function wordCountEngine, which receives a string 
// document and returns a list of all unique words in it and their number of occurrences, sorted by the number 
// of occurrences in a descending order. If two or more words have the same count, they should be sorted according 
// to their order in the original sentence. Assume that all letters are in english alphabet. You function should be 
// case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

// The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

// Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

// Examples:

// input:  document = "Practice makes perfect. you'll only
//                     get Perfect by practice. just practice!"

// output: [ ["practice", "3"], ["perfect", "2"],
//           ["makes", "1"], ["youll", "1"], ["only", "1"], 
//           ["get", "1"], ["by", "1"], ["just", "1"] ]
// Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). 
// We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.

// Constraints:
// [time limit] 5000ms
// [input] string document
// [output] array.array.string

// input:  document = "Practice makes perfect. you'll only
//                     get Perfect by practice. just practice!"

/**
 * [
 *  { perfect: 2 }
 *  { practice: 1 }
 *  { perfect: 1 }
 *  ...
 * ]
 * perfect => 2
 * practice => 1
 * makes => 1

 * youll => 1
 * only => 1
 * get => 1
 */

var wordCountEngine = function(s) {
    const arr = s.split(" "); //O(n)
    // const arr2 = new Array(s.length()); [ , , , ]

    const counter = {}; // use output array in place of the hash

    for(let i = 0; i < arr.length; i++) { // O(n)
        if(counter[arr[i].toLowerCase()]) {
            counter[arr[i].toLowerCase()]++;
        } else {
            counter[arr[i].toLowerCase()] = 1;
        }
    }

    const output = [];

    Object.keys(counter).forEach(word => {  //O(n)
        arr2[counter[word]].push([word, counter[word]])
    });

    // mwordaximum number of times a word can occur in the string = total # words in the string, length of arr
    // loop through max to 1, 5->4->3->2->1
    // 

    output = output.sort((a, b) => b[1] - a[1]); //O(n log n)

    return output.map(ele => [[ele[0], ele[1].toString()]]); // O(n)
}

function wordCountEngine(doc) {
    let docArr = doc.toLowerCase().replace(/[^a-z\s]/g, '')
        .replace(/\s\s+/g, ' ').split(' ');

    let len = docArr.length;
    let i;
    let val;
    let map = {}; // the occurrence of words
    for (i = 0; i < len; i++) {
        let val = docArr[i];
        if (map[val] === undefined) {
            map[val] = 1;
        } else {
            map[val] = map[val] + 1;
        }
    }
    // console.log(map);

    let key;
    let rtnArray = [];
    // the max occurrence is the length of words' array
    for (i = len - 1; i > -1; i--) {
        for (key in map) {
            if (map.hasOwnProperty(key)) {
                val = map[key];
                if (val === i) {
                    rtnArray.push([key, i]);
                    delete map.key;
                }
            }
        }
    }
    return rtnArray;
}

/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * 
 */

 // Assumptions
 // OK to skip elements
 // [] not given
 // Two cases:
    // we reach the end of the array, return true
    // or we reach an element with value of 0 (and not at the end), return false
// Initialize variable current index
// initialize variable for current element/ maximum jump length


// nums = [2, 3, 1, 1, 4]

// Input: nums = [3, 2, 1, 0, 4] false
// nums = [3, 1, 2, 0, 4] //true

// Tree structure
// node = first element in the array
// node's children will be all possible elements accessible from that node
//           3
//      1    2    0
//    2    0   4
//  0   4         
// stopping conditions
    // when we encounter a 0, or the last element of the array
// check children of each node
//  if one of the children == last element of the array, immediately return true
//  once we've built the entire tree, and none of the children == last element, return false
// implement BFS, queue

// nums = [3, 1, 2, 0, 4] //true
function reachEnd(arr) { // arr = [3,1,2,0,4]
    queue = [arr[0]]; // [3]
    let maxJump; 
    var currIdx = 0; 
    let maxIdx; 
    var lastEl = arr[arr.length-1]; // 4

    while(queue.length !== 0) { // 
        maxJump = queue.shift();  // maxJump = 1
        maxIdx = currIdx + maxJump; // maxIdx = 0 + 1
        if (maxJump !== 0) { 
            var i = currIdx + 1; // i = 0+1 =1
            while (i <= maxIdx) { // 4 <= 3
                if (arr[i] === lastEl) { // 0 ==? 4
                    return true;
                } else {
                    queue.push(arr[i]); // queue = [1, 2, 0]
                    i++ //4
                }
            }
        }
    }

    return false; //not able to reach the last element

}




// function reachedEnd(arr) {
//     var currIdx = 0; // 0
//     var maxJump = arr[0]; // 3

//     while (currIdx < arr.length - 1) {
//         currIdx = currIdx + currJump; // 0+3 = 3
//         currJump = arr[currIdx]; // arr[3] = 0
//         if (currJump === 0) {
//             return false; 
//         }
//     }

//     // if we reach here, we've reached the end of the arr
//     return true;

// }
