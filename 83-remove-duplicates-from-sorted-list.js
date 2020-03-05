/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/*
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function (head) {
    if (head === null) return null;
    let sentinel = head;
    let p1 = head;
    let p2 = head.next;

    while (p2 != null) {
        if (p1.val === p2.val) {
            p1.next = p2.next;
        } else {
            p1 = p1.next;
        }
        p2 = p2.next;
    }

    return sentinel;
};