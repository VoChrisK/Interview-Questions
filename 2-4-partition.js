const Node = require("./node");

/*
    Cracking the Coding Interview - Chapter 2, #2.4 - Write code to partition a linked list around a value x, such that all nodes less than x come before
    all nodes greater than or equal to x.
    
    This is a solution with O(n) time complexity and O(1) space complexity provided we are allowed to modify a node's value.
*/

const partitionSolution = function(head, k) {
    if(head === null) return head;

    let pointer1 = head;
    let pointer2 = head;
    let tempData;


    //3
    while(pointer2 !== null) {
        if(pointer2.data < k) {
            tempData = pointer2.data;
            pointer2.data = pointer1.data;
            pointer1.data = tempData;
            pointer1 = pointer1.next;
        }

        pointer2 = pointer2.next;
    }

    return head;
}

let node = new Node(5);
node.append(3);
node.append(8);
node.append(5);
node.append(10);
node.append(2);
node.append(1);

partitionSolution(node, 5);

while (node != null) {
    console.log(node.data);
    node = node.next;
}