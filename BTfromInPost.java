/* Construct Binary Tree From Inorder And Postorder
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/submissions/
https://www.interviewbit.com/old/problems/binary-tree-from-inorder-and-postorder
O(N) */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */public class BTfromInPost {
    public TreeNode buildTree(int[] A, int[] B) {
        return buildTrees(A,0,A.length-1,B,0,B.length-1);
    }
    public TreeNode buildTrees(int[] A,int as,int ae, int[] B,int bs ,int be) {
        if(as>ae){
            return null;
        }
        if(as==ae){
            return new TreeNode(A[as]);
        }
        int val=B[be];
        TreeNode root=new TreeNode(val);
        int j=as;
        for(int i=as;i<=ae;i++){
            if(val==A[i]){
                j=i;
                break;
            }
        }
        root.left=buildTrees(A,as,j-1,B,bs,bs+(j-1-as));
        root.right=buildTrees(A,j+1,ae,B,bs+(j-as),be-1);
        return root;
    }
}