/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #94 - https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

//solution 2 (May 19, 2020):

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;

        traverseLeft(root, stack);

        while (!stack.empty()) {
            node = stack.pop();
            list.add(node.val);

            if (node.right != null)
                traverseLeft(node.right, stack);
        }

        return list;
    }

    public void traverseLeft(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

//solution 1 (nonoptimal solution. I revisit non-leaf nodes twice, two months ago):

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        stack.push(root);
        TreeNode tempNode;

        while (!stack.isEmpty()) {
            tempNode = stack.pop();

            if ((tempNode.left == null && tempNode.right == null) || set.contains(tempNode)) {
                list.add(tempNode.val);
            } else {
                if (tempNode.right != null)
                    stack.push(tempNode.right);
                stack.push(tempNode);
                set.add(tempNode);
                if (tempNode.left != null)
                    stack.push(tempNode.left);
            }
        }

        return list;
    }
}