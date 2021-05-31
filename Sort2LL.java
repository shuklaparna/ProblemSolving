/* Sort the LinkedList (2 consecutive nodes represent a 2 digit number)
Problem Description:
Given a Linked List A of length N. Each number is represented by 2 consecutive nodes of the Linked List.
Suppose 2->7->5->6 is the given Linked list. Then, the numbers are 27 and 56.
Return the head of the sorted Linked List.
Problem Constraints:
0 <= N <= 100000
N is always even.
Input Format:
First argument is the head pointer of the linkedlist.
Output Format:
Return the head pointer of the sorted linkedlist as described.

Example Input:
5 -> 1 -> 0 -> 3.
Example Output:
0 -> 3 -> 5 -> 1.
Example Explanation:
First number is 51. Second number is 03.
After sorting, the list becomes 0 -> 3 -> 5 -> 1. */

//TC: O(N); SC: O(N)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Sort2LL {
    public ListNode solve(ListNode head) {
        ListNode ptr = head;
        ArrayList<Integer> list = new ArrayList<>();
        if (head == null) return head;

        while (ptr != null) {
            int n = ptr.val;
            ptr = ptr.next;
            if (ptr != null) {
                n = n * 10 + ptr.val;
                ptr = ptr.next;
            }
            list.add(n);
        }
        list.sort(Comparator.naturalOrder());
        head=new ListNode(0);
        ptr=head;
        for (int a:list){
            ptr.next=new ListNode(a/10);
            ptr=ptr.next;
            ptr.next = new ListNode(a % 10);
            ptr = ptr.next;
        }
        return head.next;
    }
}
