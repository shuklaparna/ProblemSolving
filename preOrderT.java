/* Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/
https://www.interviewbit.com/problems/preorder-traversal/
TC: O(N); SC:O(h) */
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
public class preOrderT {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
         ArrayList<Integer> list=new ArrayList<>();
        preorder(A,list);
        return list;
    }
     void preorder(TreeNode A,ArrayList<Integer> list){
        if(A == null){
           return;
        }
        list.add(A.val);
        preorder(A.left,list);
        preorder(A.right,list);
    }
}
