/* Same Binary Tree
https://leetcode.com/problems/same-tree/
https://www.interviewbit.com/problems/identical-binary-trees/
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
 //First Solution
 public class SameBT {
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A == null && B == null)
            return 1;
	    if(A == null || B == null)
	        return 0; 
	    if(A.val != B.val)
	        return 0; 
	       
	    int lTree = isSameTree(A.left, B.left);
	    int rTree = isSameTree(A.right, B.right);
	    
	    if(lTree == 1 && rTree == 1)
	       return 1;
	    else 
	       return 0; 
    }
}
 
 //Second Solution
public class Solution {
    public int isSameTree(TreeNode A, TreeNode B) {
        ArrayList<Integer> list1 = inorderTraversal(A);
        ArrayList<Integer> list2 = inorderTraversal(B);
        if(list1.equals(list2))
            return 1;
        return 0;
    }
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
