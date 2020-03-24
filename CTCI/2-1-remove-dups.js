const Node = require("../Others/node");

/*
    Cracking the Coding Interview - Chapter 2, #2.1 - Write code to remove duplicates from an unsorted linked list.
*/

const removeDups = function(head) {
    let knownValues = new Set();
    let behind;

    while(head !== null) {
        if(knownValues.has(head.data)) {
            behind.next = head.next;
        } else {
            knownValues.add(head.data);
            behind = head;
        }

        head = head.next;
    }
}

let node = new Node(3);
node.append(5);
node.append(3);
node.append(1);
node.append(4);
node.append(5);
node.append(3);
node.append(1);
node.append(2);

removeDups(node);

while(node != null) {
    console.log(node.data);
    node = node.next;
}

// 1 -> 3 -> 1 -> 3