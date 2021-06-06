/* Invert Binary Tree
https://www.interviewbit.com/problems/invert-the-binary-tree/
https://leetcode.com/problems/invert-binary-tree/
TC: O(N); SC: O(N) */
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
 //Recursive Method
public class InvertBT {
    public TreeNode invertTree(TreeNode A) {
        if(A == null)
            return A;
        TreeNode left = A.left;
        A.left = A.right;
        A.right = left;
        invertTree(A.left);
        invertTree(A.right);
        return A;
    }
}

//Iterative Method
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
    return root;
}