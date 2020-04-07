/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * Leetcode #24 - https://leetcode.com/problems/swap-nodes-in-pairs/
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swapPairs(head, 0);
    }

    public ListNode swapPairs(ListNode head, int number) {
        if (head == null)
            return head;

        ListNode node = swapPairs(head.next, ++number);
        head.next = node;
        if (number % 2 == 1) {
            if (node != null) {
                head.next = node.next;
                node.next = head;
                return node;
            }
        }
        return head;
    }
}