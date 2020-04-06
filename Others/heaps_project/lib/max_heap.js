class MaxHeap {
    constructor() {
        this.array = [null];
    }

    getParent(idx) {
        return Math.floor(idx/2);
    }

    getLeftChild(idx) {
        return (idx * 2);
    }

    getRightChild(idx) {
        return (idx * 2) + 1;
    }

    insert(val) {
        this.array.push(val);
        this.siftUp(this.array.length - 1);
    }

    siftUp(idx) {
        if(idx === 1) return;

        let parentIdx = this.getParent(idx);
        if(this.array[idx] > this.array[parentIdx]) {
            this.swap(idx, parentIdx);
        }

        this.siftUp(parentIdx);
        return;
    }

    deleteMax() {
        if(this.array.length === 1) return null;
        if(this.array.length === 2) return this.array.pop();

        const max = this.array[1];
        this.array[1] = this.array.pop();
        this.siftDown(1);

        return max;
    }

    siftDown(idx) {
        const leftIdx = this.getLeftChild(idx);
        const rightIdx = this.getRightChild(idx);
        let leftEle = this.array[leftIdx];
        let rightEle = this.array[rightIdx];

        leftEle = leftEle === undefined ? Number.NEGATIVE_INFINITY : leftEle;
        rightEle = rightEle === undefined ? Number.NEGATIVE_INFINITY : rightEle;

        if(this.array[idx] > leftEle && this.array[idx] > rightEle) return;

        if(leftEle > rightEle) {
            this.swap(idx, leftIdx);
            this.siftDown(leftIdx);
        } else {
            this.swap(idx, rightIdx);
            this.siftDown(rightIdx);
        }
    }

    swap(idx1, idx2) {
        let temp = this.array[idx2];
        this.array[idx2] = this.array[idx1];
        this.array[idx1] = temp;
    }
}

module.exports = {
    MaxHeap
};