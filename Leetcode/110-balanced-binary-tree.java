/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #110 - https://leetcode.com/problems/balanced-binary-tree/
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public int checkHeight(TreeNode root) {
        if (root == null)
            return 1;

        int left = checkHeight(root.left);
        if (left == -1)
            return -1;
        int right = checkHeight(root.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}