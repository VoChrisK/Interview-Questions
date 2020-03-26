const BinaryTree = require("../Others/binary_tree");

const validateBST = function(root) {
    return validateLeftMost(root.left, Number.POSITIVE_INFINITY, root.data) && validateRightMost(root.right, root.data, Number.NEGATIVE_INFINITY);
}

const validateLeftMost = function(root, min, max) {
    if(root === null) return true;
    
    if(root.data <= min) {
        min = root.data;
        return validateLeftMost(root.left, min, max) && validateRightSubTree(root.right, min, max);
    } else {
        return false;
    }
}

const validateRightMost = function(root, min, max) {
    if (root === null) return true;

    if (root.data > max) {
        max = root.data;
        return validateRightMost(root.right, min, max) && validateLeftSubTree(root.left, min, max);
    } else {
        return false;
    }
}

const validateRightSubTree = function(root, min, max) {
    if(root === null) return true;

    if(root.data >= min && root.data < max) {
        return validateLeftMost(root.left, min, max) && validateRightSubTree(root.right, min, max);
    } else {
        return false;
    }
}

const validateLeftSubTree = function (root, min, max) {
    if (root === null) return true;

    if (root.data >= min && root.data < max) {
        return validateRightMost(root.right, min, max) && validateLeftSubTree(root.left, min, max);
    } else {
        return false;
    }
}

const binaryTree = new BinaryTree(4);
binaryTree.append(2);
binaryTree.append(6);
binaryTree.append(1);
binaryTree.append(3);
binaryTree.append(5);
binaryTree.append(7);

console.log(validateBST(binaryTree.root));

const anotherBinaryTree = new BinaryTree(2);
anotherBinaryTree.append(1);
anotherBinaryTree.append(3);

console.log(validateBST(anotherBinaryTree.root));