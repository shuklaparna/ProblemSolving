/* Stairs
https://www.interviewbit.com/problems/stairs/
https://leetcode.com/problems/climbing-stairs/submissions/
TC: O(N); SC: O(A) */

public class StairDP {
    public int climbStairs(int A) {
        if(A == 1)
            return 1;
        int dp[] = new int[A + 1]; 
    	dp[1] = 1; dp[2] = 2;
    	for(int i = 3; i <= A; i++){
    	    dp[i] = dp[i - 1] + dp[i - 2];
    	}
    	return dp[A];
    }
}
