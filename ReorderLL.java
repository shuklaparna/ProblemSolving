/* Reorder List
https://www.interviewbit.com/problems/reorder-list/
https://leetcode.com/problems/reorder-list/
TC: O(N), SC: O(1) */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReorderLL {
    
    public ListNode reorderList(ListNode n) {
        if(n == null || n.next == null || n.next.next == null) {
            return n;
        }
        ListNode middle = getMiddleNode(n);
        ListNode temp2 = reverseList(middle.next);
        middle.next = null;
        ListNode temp1 = n;
        while(temp1 != null && temp2 != null) {
            ListNode temp3 = temp2;
            temp2 = temp2.next;
            temp3.next = temp1.next;
            temp1.next = temp3;
            temp1 = temp3.next;
        }
        return n;
    }
    
    private ListNode reverseList(ListNode A) {
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
    
    private ListNode getMiddleNode(ListNode n) {
        if(n == null) return null;
        ListNode slow = n;
        ListNode fast = n;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}