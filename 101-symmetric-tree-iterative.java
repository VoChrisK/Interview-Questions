/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 * 
 * Leetcode #101 - https://leetcode.com/problems/symmetric-tree/
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int length;
        stack.push(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            length = queue.size();
            addToStack(stack, queue, length);
            if (!compareValues(stack, queue, length))
                return false;
        }

        return true;
    }

    public void addToStack(Stack<TreeNode> stack, Queue<TreeNode> queue, int length) {
        TreeNode tempNode;

        for (int i = 0; i < length / 2; i++) {
            tempNode = queue.poll();
            stack.push(tempNode);

            if (tempNode != null) {
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }
        }
    }

    public boolean compareValues(Stack<TreeNode> stack, Queue<TreeNode> queue, int length) {
        TreeNode tempNode;
        TreeNode tempNode2;

        for (int i = length / 2; i < length; i++) {
            if (stack.isEmpty())
                return false;
            tempNode = queue.poll();
            tempNode2 = stack.pop();

            if (tempNode == null && tempNode2 == null)
                continue;
            if (tempNode != null && tempNode2 == null || tempNode == null && tempNode2 != null)
                return false;
            if (tempNode.val != tempNode2.val)
                return false;

            if (tempNode != null) {
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            }
        }

        return true;
    }
}