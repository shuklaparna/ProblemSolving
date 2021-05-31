/* Clone a Linked List
https://www.interviewbit.com/problems/copy-list/
https://leetcode.com/problems/copy-list-with-random-pointer/
TC: O(N): SC: O(N) */
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CloneLL {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        RandomListNode clone = null;
        
        while(temp != null) {
            clone = new RandomListNode(temp.label);
            map.put(temp, clone);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            clone = map.get(temp);
            clone.next = map.get(temp.next);
            clone.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
