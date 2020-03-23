/**
 * Cracking the Coding Interview - Chapter 4, #4-3 - Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g. if you have a tree with depth D, you'll have D linked lists)
 */

const BinaryTree = require('./binary_tree');
const Node = require('./node');

const listOfDepthsBFS = function(node) {
    const listOfDepths = {};
    const queue = [node];
    let tempNode;
    let depth = 0;
    let length;

    while(queue.length > 0) {
        length = queue.length;
        depth++;

        for(let i = 0; i < length; i++) {
            tempNode = queue.shift();

            if(i in listOfDepths) {
                listOfDepths[depth].append(tempNode.data);
            } else {
                listOfDepths[depth] = new Node(tempNode.data);
            }

            if(tempNode.left !== null) queue.push(tempNode.left);
            if(tempNode.right !== null) queue.push(tempNode.right);
        }
    }

    return listOfDepths;
}

const binaryTree = new BinaryTree(2);
binaryTree.append(3);
binaryTree.append(5);
binaryTree.append(1);
binaryTree.append(6);
binaryTree.append(9);
binaryTree.append(8);
binaryTree.append(7);

const listOfDepths = listOfDepthsBFS(binaryTree.root);

Object.keys(listOfDepths).forEach(depth => {
    console.log("Depth " + depth);
    listOfDepths[depth].printNodes();
    console.log("-------------------");
});

// binaryTree.preOrder(binaryTree.root);