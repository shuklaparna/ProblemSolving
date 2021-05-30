/* Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/
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
public class DiameterBT {
    int ans;
    public int solve(TreeNode A) {
        ans = 0;
        int h = height(A);
        return ans;
    }
    public int height(TreeNode A) {
        if (A == null)
            return -1;
        int l = height(A.left);
        int r = height(A.right); 
        ans = Math.max(ans, l+r+2);
        return (Math.max(l, r) + 1);
    }
}

