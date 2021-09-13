/* Duplicates in BT
https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/
TC: O(NLogN) */

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
public class DupInBT {
    HashSet<String> subtrees = new HashSet<>();
    static char MARKER = '$';
    public int solve(TreeNode A) {
        subtrees.clear();
        String ch1 = check(A);
        if(ch1.compareTo("") == 0)
            return 1;
        return 0;
    }
    public String check(TreeNode root) {
        String s = "";
        if (root == null)
            return s + MARKER;
        String lStr = check(root.left);
        if (lStr.equals(s))
            return s;
        String rStr = check(root.right);
         if (rStr.equals(s))
            return s;
        
        s = s + root.val + lStr + rStr;
        if (s.length() > 3 && subtrees.contains(s))
            return "";
     
        subtrees.add(s);
        return s;
    }
}
