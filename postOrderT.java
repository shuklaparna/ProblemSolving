/* Postorder Traversal
https://www.interviewbit.com/problems/postorder-traversal/
https://leetcode.com/problems/binary-tree-postorder-traversal/
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
public class postOrderT {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> list=new ArrayList<>();
        postorder(A,list);
        return list;
    }
     void postorder(TreeNode A,ArrayList<Integer> list){
        if(A == null){
           return;
        }
        postorder(A.left,list);
        postorder(A.right,list);
        list.add(A.val);
    }
}
