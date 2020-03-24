const mergeSort = function(arr) {
    if(arr.length === 0 || arr.length === 1) return arr;
    let mid = arr.length / 2;
    let left = mergeSort(arr.slice(0, mid));
    let right = mergeSort(arr.slice(mid));
    return merge(left, right, 0, 0);
}

const merge = function(left, right) {
    let mergedArr = [];

    while(left.length > 0 && right.length > 0) {
        if(left[0] > right[0]) {
            mergedArr.push(right[0]);
            right.shift();
        } else {
            mergedArr.push(left[0]);
            left.shift();
        }
    }

    return mergedArr.concat(left).concat(right);
}

console.log(mergeSort([2, 5, 4, 1, 3, 7]));
console.log(mergeSort(Array.from({ length: 40 }, () => Math.floor(Math.random() * 40))));