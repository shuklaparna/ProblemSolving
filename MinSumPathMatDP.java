/* min sum path in matrix
https://www.geeksforgeeks.org/min-cost-path-dp-6/
https://leetcode.com/problems/minimum-path-sum/submissions/
https://www.interviewbit.com/problems/min-sum-path-in-matrix/
TC: O(N) */

public class MinSumPathMatDP {
    public int minPathSum(int[][] a) {
        int m = a.length;
        if (m == 0) {
            return m;
        }
        int n = a[0].length;
        if (n == 0) {
            return n;
        }
        int[][] dp = new int[m][n];
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = a[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i > 0) {
                    dp[i][j] = a[i][j] + dp[i-1][j];
                } else if (j > 0) {
                    dp[i][j] = a[i][j] + dp[i][j-1];
                } else {
                    dp[i][j] = a[i][j];
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}
