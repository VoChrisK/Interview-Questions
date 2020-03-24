/*
    Cracking the Coding Interview - Chapter 3, #3.3 - Implement a data structure SetOfStacks that is composed of several stacks and should create a new
    stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is, pop()
    should return the same value as it would if there were just a single stack)

    Follow up - Implement a function popAt(index) which performs a pop operation on a specific sub-stack. I assume that if we do a pop operation on
    a specific substack, then we must shift all elements down by one to maintain the set of stacks.
*/

class SetOfStacks {
    constructor(capacity) {
        this.capacity = capacity;
        this.stacks = [];
        this.currentStack = [];
    }

    push(node) {
        if (this.currentStack.length === this.capacity) {
            this.stacks.push(this.currentStack);
            this.currentStack = [];
        }

        this.currentStack.push(node);
    }

    pop() {
        if(this.currentStack.length === 0) {
            this.currentStack = this.stacks.pop();
        }

        this.currentStack.pop();
    }

    popAt(index) {
        if(index >= this.stacks.length) return null;

        this.stacks[index].pop();
        this.rollover(index);
    }

    rollover(index) {
        while(index < this.stacks.length - 1) {
            this.stacks[index].push(this.stacks[index + 1].shift())
            index++;
        }

        if(this.currentStack.length !== 0) {
            this.stacks[index].push(this.currentStack.shift());
            if(this.currentStack.length === 0) this.currentStack = this.stacks.pop();
        }
    }
}

const setOfStacks = new SetOfStacks(3);

setOfStacks.push(1);
setOfStacks.push(3);
setOfStacks.push(5);
setOfStacks.push(7);
setOfStacks.push(9);
setOfStacks.push(11);
setOfStacks.push(13);

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.pop();
setOfStacks.pop();

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.pop();
setOfStacks.pop();
setOfStacks.pop();

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.push(15);
setOfStacks.push(17);
setOfStacks.push(19);
setOfStacks.push(21);
setOfStacks.push(23);

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.popAt(1);

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.popAt(0);

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.push(25);
setOfStacks.push(27);
setOfStacks.push(29);
setOfStacks.push(31);
setOfStacks.push(33);
setOfStacks.push(35);
setOfStacks.push(37);

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");

setOfStacks.popAt(0);

console.log(setOfStacks.currentStack);
console.log(setOfStacks.stacks);
console.log("------------------------------------");