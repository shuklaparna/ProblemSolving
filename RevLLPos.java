/* Reverse LinkedList II - from position B to C
https://www.interviewbit.com/problems/reverse-link-list-ii/
https://leetcode.com/problems/reverse-linked-list-ii/ */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 //First Method TC: O(N), SC: O(1)
public class RevLLPos {
    public ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode temp = A;
        ListNode prevtemp = null;

        int count = 1;
        while(count < B) {
            count++;
            prevtemp = temp;
            temp = temp.next;
        }

        ListNode curr = temp;
        ListNode next = null;
        ListNode prev = null;

        count--;
        while(count < C) {
            count++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(prevtemp == null) {
            A = prev;
        } 
        else {
            prevtemp.next = prev;
        }
        temp.next = curr;
        
        return A;
    }
}

//Second Method TC: O(N), SC: O(N)
class Solution {

    // Object level variables since we need the changes
    // to persist across recursive calls and Java is pass by value.
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {

        // base case. Don't proceed any further
        if (n == 1) {
            return;
        }

        // Keep moving the right pointer one step forward until (n == 1)
        right = right.next;

        // Keep moving left pointer to the right until we reach the proper node
        // from where the reversal is to start.
        if (m > 1) {
            this.left = this.left.next;
        }

        // Recurse with m and n reduced.
        this.recurseAndReverse(right, m - 1, n - 1);

        // In case both the pointers cross each other or become equal, we
        // stop i.e. don't swap data any further. We are done reversing at this
        // point.
        if (this.left == right || right.next == this.left) {
            this.stop = true;            
        }

        // Until the boolean stop is false, swap data between the two pointers
        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            // Move left one step to the right.
            // The right pointer moves one step back via backtracking.
            this.left = this.left.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head, m, n);
        return head;
    }
}