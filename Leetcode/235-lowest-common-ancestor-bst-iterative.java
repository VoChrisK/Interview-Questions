/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #235 - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if ((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val))
                return root;
            else if (p.val > root.val && q.val > root.val)
                root = root.right;
            else
                root = root.left;
        }

        return null;
    }
}