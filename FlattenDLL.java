/*  Flatten a Multilevel Doubly Linked List
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
//TC: O(NlogN); SC: O(N) 
class FlattenDLL {
    Node head;
    Node temp;
    public Node flatten(Node root) {
        if(root==null) return root;
        head=new Node(); 
        // so that head doesn't loose its original value
        temp=head;
        solve(root);
        //first node in head is garbage
        head=head.next;
        head.prev=null;
        return head;
    }
    
    void solve(Node root){
        if(root==null) return;
        // save value for later
        Node rn=root.next;
        
        temp.next=root;
        root.prev=temp;
        temp.child=null;
        temp=temp.next;
        //first iterate child then next
        solve(root.child);
        // now the value of root.next might be changed by temp, so use preserved value
        solve(rn);
    }
}