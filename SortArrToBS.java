/* Convert Sorted Array to Binary Search Tree
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
TC: O(NlogN) */

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
class SortArrToBS {
    public TreeNode sortedArrayToBST(int[] A) {
        return BalBST(A, 0 , A.length-1);
    }
    public TreeNode BalBST(int[] A , int start, int end){

        if(start > end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(A[mid]);

        root.left = BalBST(A, start, mid-1);
        root.right = BalBST(A, mid+1, end);

        return root;
    }
}