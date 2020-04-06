// you may assume that the array will always have a null element at the 0-th index
function isMaxHeap(array) {
    const queue = [1];
    let index;
    let length;
    let leftEle;
    let rightEle;

    while (queue.length > 0) {
        length = queue.length;
        for (let i = 0; i < length; i++) {
            index = queue.shift();
            leftEle = array[index * 2] === undefined ? Number.NEGATIVE_INFINITY : array[index * 2];
            rightEle = array[(index * 2) + 1] === undefined ? Number.NEGATIVE_INFINITY : array[(index * 2) + 1];

            if (array[index] < leftEle || array[index] < rightEle) return false;

            if (array[index * 2] !== undefined) queue.push(index * 2);
            if (array[(index * 2) + 1] !== undefined) queue.push((index * 2) + 1);
        }
    }

    return true;
}


module.exports = {
    isMaxHeap
};