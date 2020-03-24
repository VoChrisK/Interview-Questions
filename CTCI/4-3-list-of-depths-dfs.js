/**
 * Cracking the Coding Interview - Chapter 4, #4-3 - Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g. if you have a tree with depth D, you'll have D linked lists)
 */

const BinaryTree = require('../Others/binary_tree');
const Node = require('../Others/node');

const listOfDepthsDFS = function(node, depth, listOfDepths) {
    if(node == null) {
        return listOfDepths;
    }

    if(depth in listOfDepths) {
        listOfDepths[depth].append(node.data);
    } else {
        listOfDepths[depth] = new Node(node.data);
    }

    return Object.assign(listOfDepthsDFS(node.left, depth + 1, listOfDepths), listOfDepthsDFS(node.right, depth + 1, listOfDepths));
} 

const binaryTree = new BinaryTree(2);
binaryTree.append(3);
binaryTree.append(5);
binaryTree.append(1);
binaryTree.append(6);
binaryTree.append(9);
binaryTree.append(8);
binaryTree.append(7);

const listOfDepths = listOfDepthsDFS(binaryTree.root, 1, {});

Object.keys(listOfDepths).forEach(depth => {
    console.log("Depth " + depth);
    listOfDepths[depth].printNodes();
    console.log("-------------------");
});