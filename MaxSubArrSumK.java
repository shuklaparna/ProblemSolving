/* Maximum subarray size, such that all subarrays of that size have sum less than k
https://www.geeksforgeeks.org/maximum-subarray-size-subarrays-size-sum-less-k/
TC: O(N) */

public class MaxSubArrSumK {
    public int solve(int[] arr, int k) {
        int n = arr.length;
        int ans = n;
        int sum = 0;
        int start = 0;
        for(int end = 0; end < n; end++) {
            sum += (int)arr[end];
             
            while (sum > k) {
                sum -= (int)arr[start];
                start++;
                ans = Math.min(ans, end - start + 1);
                if (sum == 0)
                    break;
            }
             
            if (sum == 0) {
                ans = -1;
                break;
            }
        }
        return ans;
    }
}
