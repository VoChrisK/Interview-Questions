/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/*
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 * 
 * Leetcode #19 - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
var removeNthFromEnd = function (head, n) {
    let behind = new ListNode(0);
    behind.next = head;
    let sentinel = behind;
    let slow = head;
    let fast = head;

    while (n > 0 && fast !== null) {
        fast = fast.next;
        n--;
    }

    while (fast !== null) {
        behind = slow;
        slow = slow.next;
        fast = fast.next;
    }

    behind.next = slow.next;

    return sentinel.next;
};