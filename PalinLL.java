/* Palindrome List
https://www.interviewbit.com/problems/palindrome-list/
https://leetcode.com/problems/palindrome-linked-list/
TC: O(N), SC: O(1); 4ms */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class PalinLL {
    public int lPalin(ListNode A) {
        
        if(A==null||A.next==null){
            return 1;
        }
        ListNode slow=A;
        ListNode fast=A;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverseList(slow.next);
        
        slow=slow.next;
        while(slow!=null){
            if(A.val!=slow.val){
                return 0;
            }
            A=A.next;
            slow=slow.next;
        }
        return 1;
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
}
