/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #94 - https://leetcode.com/problems/binary-tree-inorder-traversal/
 * My solution is nonoptimal. I revisit non-leaf nodes twice. Will redo later
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        stack.push(root);
        TreeNode tempNode;

        while (!stack.isEmpty()) {
            tempNode = stack.pop();

            if ((tempNode.left == null && tempNode.right == null) || set.contains(tempNode)) {
                list.add(tempNode.val);
            } else {
                if (tempNode.right != null)
                    stack.push(tempNode.right);
                stack.push(tempNode);
                set.add(tempNode);
                if (tempNode.left != null)
                    stack.push(tempNode.left);
            }
        }

        return list;
    }
}