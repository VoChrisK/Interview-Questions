/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #112 - https://leetcode.com/problems/path-sum/
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, sum, 0);
    }

    public boolean pathSum(TreeNode root, int sum, int current) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return current + root.val == sum ? true : false;
        return pathSum(root.left, sum, current + root.val) || pathSum(root.right, sum, current + root.val);
    }
}