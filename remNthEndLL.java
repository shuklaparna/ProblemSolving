/* Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
https://www.interviewbit.com/problems/remove-nth-node-from-list-end/ */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 /*First Method
 TC: O(N); SC: O(N) */
public class remNthEndLL {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int n;
	    ListNode node;
	    if (A == null)
	        return null;
	    
	    n = 0;
	    node = A;
	    
	    while (node != null) {
	        n++;
	        node = node.next;
	    }
	    
	    if (B >= n) {
	        return A.next;
	    }
	    node = A;
	    for(int i = 0; i < n - B - 1; i++)
			node = node.next;
		node.next = node.next.next;
	    
	    return A;
        
    }
}

/*Second Method
 TC: O(N); SC: O(1) */
 public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length  = 0;
    ListNode first = head;
    while (first != null) {
        length++;
        first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
        length--;
        first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
}