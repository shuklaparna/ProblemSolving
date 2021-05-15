/* Add two Linked List
https://www.interviewbit.com/problems/add-two-numbers-as-lists/
https://leetcode.com/problems/add-two-numbers/
Time complexity : O(max(m, n))
Space complexity : O(max(m, n))
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Sum2LL {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if(B == null) 
            return A;
        if(A == null) 
            return B;
        ListNode sumNode = new ListNode(0);
        ListNode prev = sumNode;
        int c = 0, sum;
        while (A != null || B != null) {
            int x = (A != null) ? A.val : 0;
            int y = (B != null) ? B.val : 0;
            sum = c + x + y;
            c = sum / 10;
            prev.next = new ListNode(sum % 10);
            prev = prev.next;
            if (A != null) A = A.next;
            if (B != null) B = B.next;
        }
        if(c > 0) 
            prev.next = new ListNode(c);
        return sumNode.next;
    }
}
