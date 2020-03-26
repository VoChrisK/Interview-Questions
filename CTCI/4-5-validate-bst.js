const BinaryTree = require("../Others/binary_tree");

const validateBST = function(root) {
    return validateSubTree(root.left, Number.POSITIVE_INFINITY, root.val) && validateSubTree(root.right, root.val, Number.NEGATIVE_INFINITY);
}

const validateSubTree = function(root, min, max) {
    if(root === null) return true;

    if(root.val <= min) {
        min = root.val;
    } else if(root.val > max) {
        max = root.val;
    } else if (root.val > min && root.val < max) {
        return validateSubTree(root.left, min, max) && validateSubTree(root.right, min, max);
    } else {
        return false;
    }

    return validateSubTree(root.left, min, max) && validateSubTree(root.right, min, max);
}

const binaryTree = new BinaryTree(4);
binaryTree.append(2);
binaryTree.append(6);
binaryTree.append(1);
binaryTree.append(3);
binaryTree.append(5);
binaryTree.append(7);

console.log(validateBST(binaryTree.root));

const anotherBinaryTree = new BinaryTree(4);
anotherBinaryTree.append(5);
anotherBinaryTree.append(1);
anotherBinaryTree.append(2);
anotherBinaryTree.append(3);
anotherBinaryTree.append(4);

console.log(validateBST(anotherBinaryTree.root));