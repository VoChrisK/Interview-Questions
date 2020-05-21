# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Leetcode #102 - https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        levels = []
        queue = []
        length = 0
        
        if root != None:
            queue.append(root)
        
        while len(queue) > 0:
            length = len(queue)
            level = []
            
            for i in range(length):
                node = queue.pop(0)
                level.append(node.val)
                
                if node.left != None:
                    queue.append(node.left)
                    
                if node.right != None:
                    queue.append(node.right)
                    
            levels.append(level)
            
        return levels