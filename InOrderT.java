/* Inrorder Traversal
https://www.interviewbit.com/problems/inorder-traversal/
https://leetcode.com/problems/binary-tree-inorder-traversal/
TC: O(N); SC: O(logN) */
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class InOrderT {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(A,list);
        return list;
    }
     void inorder(TreeNode A,ArrayList<Integer> list){
        if(A == null){
           return;
        }
        inorder(A.left,list);
        list.add(A.val);
        inorder(A.right,list);
    }
}
