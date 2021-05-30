/* Difference between sums at Odd and Even Levels
https://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
TC: O(N), SC: O(N) */
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
public class OdEvLevT {
    public int solve(TreeNode A) {
         if(A == null)
            return 0;
            
        Queue <TreeNode> q = new LinkedList<>();
        int oddsum = 0, evensum = 0, level = 0;
        q.add(A);
        
        while(!q.isEmpty()){
            int n = q.size();
            level++;
            while(n-- > 0){
                TreeNode temp = q.remove();
                if(temp.left != null)
                    q.add(temp.left);
                if(temp.right != null)
                    q.add(temp.right);
                
                if(level%2 != 0)
                    oddsum += temp.val;
                else
                    evensum += temp.val;
            }
        }
        return (oddsum-evensum);
    }
}
