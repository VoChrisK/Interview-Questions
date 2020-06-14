/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * Leetcode #111 - https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
class Solution {
    public int minDepth(TreeNode root) {
        int res = recurseDown(root);
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    
    public int recurseDown(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE; // this will only return if a node have exactly ONE child. Overflow will not happen
        if(root.left == null && root.right == null) return 1; // return 1 if node is a leaf (account for itself)
        
        return Math.min(recurseDown(root.left), recurseDown(root.right)) + 1; // if max value is returned from one child, then the other child's value will be returned
    }
}