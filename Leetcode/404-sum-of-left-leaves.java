/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * 
 * Leetcode #404 - https://leetcode.com/problems/sum-of-left-leaves/
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return isLeaf(root.left) ? sum + root.left.val : sum;
    }
    
    public boolean isLeaf(TreeNode root) {
        if(root == null) return false;
        return root.left == null && root.right == null;
    }
}