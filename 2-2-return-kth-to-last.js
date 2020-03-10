const Node = require("./node");

/*
    Cracking the Coding Interview - Chapter 2, #2.2 - Implement an algorithm to find the kth to last element of a singly linked list.
    Assume k > 0.
*/

//iterative approach
const returnKthIterative = function(head, k) {
    let slow = head;
    let fast = head;

    while(k > 0 && fast !== null) {
        fast = fast.next;
        k--;
    }

    while(fast !== null) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow.data;
}

const store = {
    data: null,
    level: 0
}

//recursive approach
const returnKthRecursive = function(head, k) {
    if(head === null) {
        store.level = k;
        return store;
    }

    let newStore = returnKthRecursive(head.next, k);
    newStore.level--;
    if (newStore.level === 0) {
        newStore.data = head.data;
    }

    return newStore;
}

let node = new Node(1);
node.append(2);
node.append(3);
node.append(4);
node.append(5);
node.append(6);
node.append(7);
node.append(8);
node.append(9);

console.log(returnKthIterative(node, 4));
console.log(returnKthRecursive(node, 4).data);

