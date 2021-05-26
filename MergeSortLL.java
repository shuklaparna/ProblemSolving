/* Merge 2 sorted LinkedLists
https://leetcode.com/problems/merge-two-sorted-lists/
https://www.interviewbit.com/problems/merge-two-sorted-lists/ */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 //Iterative Method TC: O(M+N); SC: O(1)
public class MergeSortLL {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head=new ListNode(0);
	    ListNode temp=head;
	    while(a!=null && b!=null){
	        if(a.val<=b.val){
	            temp.next=new ListNode(a.val);
	            temp=temp.next;
	            a=a.next;
	        }
	        else{
	            temp.next=new ListNode(b.val);
	            temp=temp.next;
	            b=b.next;
	        }
	    }
	    if(a==null)
	    temp.next=b;
	    else
	    temp.next=a;
	    head=head.next;
	    return head;
    }
}

//Recursive Method TC: O(N), SC: O(N)
class Solution {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
 
        // start with the linked list
        // whose head data is the least
        if (h1.val < h2.val) {
            h1.next = mergeTwoLists(h1.next, h2);
            return h1;
        }
        else {
            h2.next = mergeTwoLists(h1, h2.next);
            return h2;
        }
    }