class SortStack {
    constructor() {
        this.mainStack = [];
        this.temporaryStack = [];
    }

    push(data) {
        while(!this.isEmpty() && data > this.peek()) {
            this.temporaryStack.push(this.pop());
        }

        this.mainStack.push(data);

        while(this.temporaryStack.length > 0) {
            this.mainStack.push(this.temporaryStack.pop());
        }
    }

    pop() {
        return this.mainStack.pop();
    }

    peek() {
        const top = this.mainStack[this.mainStack.length - 1];
        return top;
    }

    isEmpty() {
        return this.mainStack.length === 0;
    }
}

const sortStack = new SortStack();
sortStack.push(3);
sortStack.push(2);
sortStack.push(4);

console.log(sortStack.mainStack);

sortStack.push(7);

console.log(sortStack.mainStack);

sortStack.push(5);

console.log(sortStack.mainStack);



