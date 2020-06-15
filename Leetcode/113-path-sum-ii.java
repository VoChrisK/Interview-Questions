/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 * 
 * Leetcode #113 - https://leetcode.com/problems/path-sum-ii/
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        pathSum(root, sum, 0, new ArrayList<Integer>(), sums);
        return sums;
    }

    public void pathSum(TreeNode root, int sum, int currentSum, List<Integer> path, List<List<Integer>> sums) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == sum) {
                path.add(root.val);
                sums.add(new ArrayList(path));
                path.remove(path.size() - 1);
            } else {
                return;
            }
        }

        path.add(root.val);
        pathSum(root.left, sum, currentSum + root.val, path, sums);
        pathSum(root.right, sum, currentSum + root.val, path, sums);
        path.remove(path.size() - 1);
    }
}