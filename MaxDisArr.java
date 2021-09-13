/* Max Distance
https://www.interviewbit.com/problems/max-distance/
https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
TC: O(NLOGN) */
//InterviewBit Soln
public class MaxDisArr {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
         int maxDiff;
        int i, j;

        int n = A.size();
        int RMax[] = new int[n];
        int LMin[] = new int[n];

        LMin[0] = A.get(0);

        for (i = 1; i < n; ++i) {
            LMin[i] = Math.min(A.get(i), LMin[i - 1]);
        }

        RMax[n - 1] = A.get(n - 1);
        for (j = n - 2; j >= 0; --j) {
            RMax[j] = Math.max(A.get(j), RMax[j + 1]);
        }

        i = 0; j = 0; maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
            else {
                i++;
            }
        }

        return maxDiff;
    }
}

//Leetcode Soln
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maximumGap(final int[] A) {
        if(A==null||A.length==0)return 0;
        int[] rmax=new int[A.length];
        int n=A.length;
        int[] lmax=new int[n];
        rmax[n-1]=A[n-1];
        for(int i=n-2;i>=0;i--)rmax[i]=Math.max(rmax[i+1],A[i]);
        lmax[0]=A[0];
        for(int i=1;i<n;i++)lmax[i]=Math.min(lmax[i-1],A[i]);
        int i=0,j=0,max=0;
        while(i<n&&j<n){
            if(lmax[i]<=rmax[j]){
                max=Math.max(max,Math.abs(j-i));
                j++;
            }else{
                i++;
            }
        }
        return max;
    }
}

