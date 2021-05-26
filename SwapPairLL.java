/* Swap List Nodes in Pairs
https://leetcode.com/problems/swap-nodes-in-pairs/
https://www.interviewbit.com/problems/swap-list-nodes-in-pairs/
TC: O(N); SC: O(1) */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SwapPairLL {
    public ListNode swapPairs(ListNode A) {
        if(A == null || A.next == null)
            return A;
            
        ListNode head = A;
        ListNode current = A;
        while(current != null && current.next != null) {
            int temp = current.val;
            current.val = current.next.val;
            current.next.val = temp;
            current = current.next.next;
        }

        return head;
    }
}
