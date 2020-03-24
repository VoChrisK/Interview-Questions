/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 * 
 * Leetcode #160 -
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> knownNodes = new HashSet<ListNode>();

        while (headA != null) {
            knownNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (knownNodes.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }
}