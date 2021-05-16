/* Reverse a LinkedList
https://leetcode.com/problems/reverse-linked-list/ */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //Iterative Method
//TC: O(N); SC: O(1)
class RevLL {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode current = A;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        A = prev;
        return A;
    }
}
//Recursive Method
//TC: O(N); SC: O(N)
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}