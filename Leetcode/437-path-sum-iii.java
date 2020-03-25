/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #437 - https://leetcode.com/problems/path-sum-iii/
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        return pathSum(root, sum, list);
    }

    public int pathSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null)
            return 0;

        int count = 0;
        int add;
        List<Integer> newList = new ArrayList<Integer>(list);

        if (root.val == sum)
            count++;

        for (int i = 0; i < newList.size(); i++) {
            add = newList.get(i) + root.val;
            if (add == sum)
                count++;
            newList.set(i, add);
        }

        newList.add(root.val);
        count += pathSum(root.left, sum, newList) + pathSum(root.right, sum, newList);
        return count;
    }
}