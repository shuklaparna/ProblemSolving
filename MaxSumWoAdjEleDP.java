/* Max Sum Without Adjacent Elements
https://www.interviewbit.com/problems/max-sum-without-adjacent-elements/
TC: O(N) */

public class MaxSumWoAdjEleDP {
    public int adjacent(int[][] A) {
        if(A.length == 0)
            return 0;
        int m = A.length;
        int n = A[0].length;
        if(n == 0)
            return 0;
        
        int[] dp = new int[n];
        int[] first = A[0];
        int[] second = A[1];
        dp[0] = Math.max(first[0], second[0]);
        if(n < 2)
            return dp[0];
            
        dp[1] = Math.max(first[1], second[1]);
        dp[1] = Math.max(dp[0], dp[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(first[i], second[i]);
            dp[i] += dp[i-2];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        return dp[n-1];
    }
}
