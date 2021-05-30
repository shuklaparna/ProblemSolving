/* Minimum Depth of Binary Tree
https://www.interviewbit.com/problems/min-depth-of-binary-tree/
https://leetcode.com/problems/minimum-depth-of-binary-tree/
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
public class minDepthBT {
    public int minDepth(TreeNode a) {
       if(a==null)
	       return 0; 
	  
	    if(a.left==null && a.right==null)
	       return 1; 
	   
	    if(a.left==null)
	       return minDepth(a.right) +1; 
	       
	    if(a.right==null)
	        return minDepth(a.left) +1; 
	       
	    int lDepth= minDepth(a.left);
	    int rDepth= minDepth(a.right);
	    
	    return Math.min(lDepth,rDepth)+1;
    }
}

