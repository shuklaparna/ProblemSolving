/* Max Product Subarray
https://www.interviewbit.com/problems/max-product-subarray/
https://leetcode.com/problems/maximum-product-subarray/
https://www.geeksforgeeks.org/maximum-product-subarray/
O(N); O(1) */

public class MaxProdSubArr {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        int maxProd = A[0];
        int max = A[0];
        int min = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] < 0) {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(A[i], max * A[i]);
            min = Math.min(A[i], min * A[i]);
            maxProd = Math.max(maxProd, max);
        }
        return maxProd;
    }
}
