/*Count Complete Tree Nodes
https://leetcode.com/problems/count-complete-tree-nodes/
TC: O(N); SC:O(logN) */
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
 */
class CountBT {
    public int countNodes(TreeNode A) {
        if(A == null)
            return 0;
        return(countNodes(A.left) + countNodes(A.right) + 1);
    }
}