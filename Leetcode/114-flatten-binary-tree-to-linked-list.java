/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 * 
 * Leetcode 114 - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        postOrder(root, stack);
        if (!stack.empty())
            stack.pop();

        while (!stack.empty()) {
            root.right = stack.pop();
            root = root.right;
        }
    }

    public void postOrder(TreeNode root, Stack<TreeNode> stack) {
        if (root == null)
            return;

        postOrder(root.right, stack);
        postOrder(root.left, stack);
        stack.push(root);
        root.left = null;
        root.right = null;
    }
}