const TreeNode = require("./treenode");

module.exports = class BinaryTree {
    constructor(data) {
        this.root = new TreeNode(data);
    }

    append(data) {
        const queue = [this.root];
        let tempNode;

        while(queue.length > 0) {
            tempNode = queue.shift();

            if(tempNode.left === null) {
                tempNode.left = new TreeNode(data);
                break;
            } else {
                queue.push(tempNode.left);
            }
        
            if (tempNode.right === null) {
                tempNode.right = new TreeNode(data);
                break;
            } else {
                queue.push(tempNode.right);
            }
        }
    }

    inOrder(node) {
        if(node === null) return;

        this.inOrder(node.left);
        console.log(node.data);
        this.inOrder(node.right);

        return;
    }

    postOrder(node) {
        if(node === null) return;

        this.postOrder(node.left);
        this.postOrder(node.right);
        console.log(node.data);

        return;
    }

    preOrder(node) {
        if (node === null) return;

        console.log(node.data);
        this.preOrder(node.left);
        this.preOrder(node.right);

        return;
    }
}