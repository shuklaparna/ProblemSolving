/* Check if a given Binary Tree is SumTree
https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
O(N) */
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
public class BTSumT {
    Boolean ans = true;
    public int solve(TreeNode A) {
        recur(A);
        return ans ? 1 : 0;
    }
    public int recur(TreeNode A){
        if(A==null)
            return 0;
            
        if(A.right==null && A.left == null){
            return A.val;
        }
        int l = recur(A.left);
        int r = recur(A.right);
        if((l+r)!=0 && (l+r)!=A.val){
            ans=false;
        }
        return (l+r+A.val);
    }
}
