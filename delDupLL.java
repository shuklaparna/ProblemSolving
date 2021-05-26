/* Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
https://www.interviewbit.com/problems/remove-duplicates-from-sorted-list/
TC: O(N); SC: O(1) */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class delDupLL {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode curr = A;
        while (curr != null) {
          int val = curr.val;
          ListNode temp = curr;
          while (temp != null && temp.val == val) {
            temp = temp.next;
          }
          curr.next = temp;
          curr = curr.next;
        }
        return A;
    }
}
