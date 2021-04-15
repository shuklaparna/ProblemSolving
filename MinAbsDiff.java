/* Minimize the Absolute Difference
https://www.interviewbit.com/problems/minimize-the-absolute-difference/
TC: O(O(N); SC: O(1) */

public class MinAbsDiff {
    public int solve(int[] A, int[] B, int[] C) {
        int nA = A.length, nB = B.length, nC = C.length;
        int i = 0, j = 0, k = 0;
        int diff = Integer.MAX_VALUE;
        while(i < nA && j < nB && k < nC) {
            int max = Math.max(A[i], Math.max(B[j], C[k]));
            int min = Math.min(A[i], Math.min(B[j], C[k]));

            if (Math.abs(max - min) < diff) {
                diff = Math.abs(max - min);
            }

            if (diff == 0) break;

            if (A[i] == min) 
                i++;
            else if (B[j] == min)
                j++;
            else k++;
        }

        return diff;
    }
}
