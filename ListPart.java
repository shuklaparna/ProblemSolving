/* Partition List
https://www.interviewbit.com/problems/partition-list/
https://leetcode.com/problems/partition-list/
TC: O(N), SC: O(1) */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ListPart {
    public ListNode partition(ListNode A, int B) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        while (A != null) {
            if (A.val < B) {
                curr1.next = new ListNode(A.val);
                curr1 = curr1.next;
            }
            else {
                curr2.next = new ListNode(A.val);
                curr2 = curr2.next;
            }
            A = A.next;
        }

        curr1.next = l2.next;
        
        return l1.next;
    }
}