/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 * 
 * Leetcode #2 - https://leetcode.com/problems/add-two-numbers/
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode head = sentinel;
        int carry = 0;
        int sum = 0;
        
        while(l1 != null || l2 != null) {
            sum = carry;
            carry = 0;
            
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            if(sum >= 10) {
                sum %= 10;
                carry = 1;
            }
            
            head.next = new ListNode(sum);
            head = head.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry == 1) head.next = new ListNode(1);
        
        return sentinel.next;
    }
}