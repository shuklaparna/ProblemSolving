/* Closest pair from sorted arrays
https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
 TC: O(N+M); SC:O(1) */
public class ClosePair {
    public int[] solve(int[] A, int[] B, int C) {
        int p1 = 0, p2 = B.length - 1;
        int res[] = new int[]{-1, -1};
        int diff = Integer.MAX_VALUE;
         int idx_A = 0, idx_B = 0;
       while (p1 < A.length && p2 >= 0) {
           if (Math.abs(A[p1] + B[p2] - C) < diff) {
               idx_A = p1;
               idx_B = p2;
               diff = Math.abs(A[p1] + B[p2] - C);
           }
             else if(Math.abs(A[p1] + B[p2] - C) == diff && idx_A == p1)
            {
                idx_B = p2;
            }
                
            if(A[p1] + B[p2] >= C) 
				p2--;
            else
				p1++;
        }
        res[0] = A[idx_A];
        res[1] = B[idx_B];
        return res;
    }
}
