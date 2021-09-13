/* max sum contiguous subarray 
https://www.interviewbit.com/old/problems/max-sum-contiguous-subarray/
https://leetcode.com/problems/maximum-subarray/
TC: O(N) */

public class MaxSumContSubArr {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int prev = A[0], ans = A[0];
        for(int i = 1; i < A.length; i++) {
            int cur = Math.max(prev+A[i], A[i]);
            prev = cur;
            ans = Math.max(prev, ans);
        }
        return ans;
    }
}
