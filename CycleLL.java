/* List Cycle
https://www.interviewbit.com/problems/list-cycle/
https://leetcode.com/problems/linked-list-cycle/
TC: O(N); SC: O(1) */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 //FirstMethod
public class CycleLL {
	public ListNode detectCycle(ListNode A) {
	    if(A == null || A.next == null)
	        return null;
	   ListNode slow1 = A, fast = A;
	   while(fast != null && fast.next != null) {
	       slow1 = slow1.next;
	       fast = fast.next.next;
	       
	       if(slow1 == fast) {
	           ListNode slow2 = A;
	           while(slow1 != slow2) {
	               slow1 = slow1.next;
	               slow2 = slow2.next;
	           }
	           return slow2;
	       }
	   }
	   return null;
	}
}

//SecondMethod
public class Solution {
	public ListNode detectCycle(ListNode A) {

	    HashSet<ListNode> hashSet = new HashSet<>();
	    
	    while (A != null) {
	        if (hashSet.contains(A)) {
	            return A;
	        } else {
	            hashSet.add(A);
	        }
	        A = A.next;
	    }
	    
	    return null;
	}
}
