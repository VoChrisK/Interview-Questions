/*
    
*/

const TreeNode = require("../Others/treenode");
const BinaryTree = require("../Others/binary_tree");

const createMinimalTree = function(arr, root, i, j) {
    if(i > j) return root;
    let mid = Math.floor((i + j) / 2);
    root = new TreeNode(arr[mid]);
    root.left = createMinimalTree(arr, root.left, i, mid-1);
    root.right = createMinimalTree(arr, root.right, mid+1, j);
    return root;
}

const arr1 = [1, 2, 3, 4, 5, 6, 7];
const root1 = createMinimalTree(arr1, null, 0, arr1.length);
console.log(root1);
console.log("----------------------");

const arr2 = [1, 2, 3, 4, 5, 6, 7, 8];
const root2 = createMinimalTree(arr2, null, 0, arr2.length);
console.log(root2);
console.log("----------------------");

const arr3 = [1, 6, 12, 44, 52, 59, 67, 100, 109, 222];
const root3 = createMinimalTree(arr3, null, 0, arr3.length);
console.log(root3);
console.log("----------------------");

const binaryTree = new BinaryTree(-1);

binaryTree.inOrder(root1);
binaryTree.inOrder(root2);
binaryTree.inOrder(root3);