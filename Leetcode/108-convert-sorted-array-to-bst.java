/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 * 
 * Leetcode #108 - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int i, int j) {
        if (i > j)
            return null;

        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, i, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, j);

        return node;
    }
}