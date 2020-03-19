class StackMin {
    constructor() {
        this.stack = [];
    }

    push(node) {
        node.min = this.isEmpty() ? node.data : Math.min(this.peek().data, node.data);
        this.stack.push(node);
    }

    pop() {
        if(!this.isEmpty()) this.stack.pop();
    }

    isEmpty() {
        return this.stack.length === 0;
    }

    peek() {
        return this.isEmpty() ? null : this.stack[this.stack.length - 1];
    }

    getMin() {
        return this.isEmpty() ? null : this.peek().min;
    }
}

class Node {
    constructor(data) {
        this.data = data;
        this.min;
    }
}

const stackMin = new StackMin();
stackMin.push(new Node(3));
stackMin.push(new Node(1));
stackMin.push(new Node(5));
stackMin.push(new Node(-1));
stackMin.push(new Node(2));
console.log(stackMin.getMin());
stackMin.pop();
stackMin.pop();
console.log(stackMin.getMin());
stackMin.pop();
stackMin.pop();
console.log(stackMin.getMin());