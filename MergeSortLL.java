/* Merge 2 sorted LinkedLists
https://leetcode.com/problems/merge-two-sorted-lists/
https://www.interviewbit.com/problems/merge-two-sorted-lists/
TC: O(M+N); SC: O(1) */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeSortLL {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode temp = new ListNode(-1);
        ListNode curr = temp;
        while (A != null || B != null) {
            int t = -1;
            if (A != null && B != null) {
                if (A.val < B.val) {
                  t = A.val;
                  A = A.next;
                }
                else {
                  t = B.val;
                  B = B.next;
                }
            }
            else if (A != null && B == null) {
                t = A.val;
                A = A.next;
            }
            else {
                t = B.val;
                B = B.next;
            }
            curr.next = new ListNode(t);
            curr = curr.next;
        }
        return temp.next;
    }
}