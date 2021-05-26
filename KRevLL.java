/* K reverse linked list
https://www.interviewbit.com/problems/k-reverse-linked-list/
TC: O(N); O(1) */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class KRevLL {
    public ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;
        
        int count = 0;

        while (count < B && current != null) {
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
           count++;
        }

        if (next != null) 
          A.next = reverseList(next, B);

        return prev;
    }
}

/* Reverse Nodes in k-Group
https://leetcode.com/problems/reverse-nodes-in-k-group/
TC: O(N); O(1) */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        int i=0;

        ListNode p = head;
        while(p!=null){
            i++;
            if(i%k==0){
                prev = reverse(prev, p.next);
                p = prev.next;
            }
            else {
                p = p.next; 
            }
        }
        return fake.next; 
    }
    public ListNode reverse(ListNode prev, ListNode next){
        ListNode last = prev.next;
        ListNode curr = last.next;

        while(curr != next){
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last; 
    }
    
}