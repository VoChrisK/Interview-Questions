/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 * 
 * Leetcode #145 -
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        TreeNode node;

        if (root != null)
            stack.push(root);

        while (!stack.empty()) {
            node = stack.pop();

            if (!set.contains(node)) {
                stack.push(node);
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);

                set.add(node);
            } else {
                list.add(node.val);
            }
        }

        return list;
    }
}