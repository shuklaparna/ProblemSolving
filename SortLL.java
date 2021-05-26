/* Sort List
https://www.interviewbit.com/problems/sort-list/
https://leetcode.com/problems/sort-list/
TC: O(NlogN); SC: O(logN) */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

public class SortLL {
    public ListNode sortList(ListNode A) {
        if(A == null )
            return null;
        if(A.next == null)
            return A;
        ListNode slow = A, fast = A;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = A;
        ListNode right = slow.next;
        slow.next=null;
        left=sortList(A);
        right=sortList(right);
        return(mergeTwoLists(left, right));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } 
            else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if(list1 != null)
            temp.next = list1;
        else
            temp.next = list2;
        return head.next;
    }
}
