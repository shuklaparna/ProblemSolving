/*  Remove Duplicates from Sorted List II
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list-ii/
TC: O(N); SC: O(1) */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class del2DupLL {
    public ListNode deleteDuplicates(ListNode A) {
        if(A == null) 
            return A;
        ListNode temp = new ListNode(0);
        temp.next = A;
        ListNode pre = temp, cur = A;
        while(cur != null) {
            while(cur.next != null && pre.next.val == cur.next.val)
                cur = cur.next;
            if (pre.next == cur) 
                pre = pre.next;
            else 
                pre.next = cur.next;
            cur = cur.next;
        }
        return temp.next;
    }
}
