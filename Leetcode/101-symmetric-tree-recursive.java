/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #101 - https://leetcode.com/submissions/detail/248248838/
 * This solution was written 7 months ago starting from today.
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;

        return isSymmetric(left, right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        boolean flag = true;

        if (left == null && right == null)
            return flag;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        flag = isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

        return flag;
    }
}