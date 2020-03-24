const Node = require("../Others/node");

/*
    Cracking the Coding Interview - Chapter 2,

    Assume that we have the length of the list.
*/

var counter = 1;

const store = {
    node: null,
    flag: true
}

const checkPalindrome = function(head, length) {
    if(counter === Math.round(length / 2)) {
        if(head.data !== head.next.data && length % 2 === 0) store.flag = false;
        
        if(length % 2 === 0) {
            store.node = head.next.next;
        } else {
            store.node = head.next;
        }
        return store;
    }

    counter++;
    let newStore = checkPalindrome(head.next, length);
    if (head.data !== newStore.node.data) {
        store.flag = false;
    }
    newStore.node = newStore.node.next;
    return newStore;
}

let node = new Node(2);
node.append(1);
node.append(2);
node.append(1);
node.append(2);

console.log(checkPalindrome(node, 5).flag);