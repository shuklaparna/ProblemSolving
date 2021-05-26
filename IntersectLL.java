/* Intersection of Linked Lists
https://www.interviewbit.com/problems/intersection-of-linked-lists/
TC: O(N); SC: O(1) */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class IntersectLL {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) return null;
        int lenA = getLength(A);
        int lenB = getLength(B);
        ListNode h1 = A, h2 = B;
        int diff = Math.abs(lenA - lenB);
        if(lenA > lenB) {
            while(diff != 0) {
                A = A.next;
                diff--;
            }
        }
        else {
            while(diff != 0) {
                B = B.next;
                diff--;
            }
        }
        while(B != null) {
            if(A == B)
                return A;
            else {
                A = A.next;
                B = B.next;
            }
        }
        return null;

    }
    public int getLength(ListNode head) {
        int l = 0;
        while (head != null) {
            head = head.next;
            l++;
        }
        return l;
    }
}
