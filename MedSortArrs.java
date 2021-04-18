/* Median of two Sorted Array
https://www.interviewbit.com/problems/median-of-array/
TC: O(M+N); SC: O(1) */

//First Method
public class MedSortArrs {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
	    int m = A.size(), n = B.size();
	    
	    if (m > n){
	        return findMedianSortedArrays(B,A);
	    }
	    int low=0, high = m;

        while(low <= high) {

            int part1 = (low + high) / 2;
            int part2 = ((m+n+1) / 2) - part1;
            
            if (part2 > 0 && part1 < m && B.get(part2-1) > A.get(part1)) {
                low = part1 + 1;
            } 
            else if (part1 > 0 && part2 < n && A.get(part1-1) > B.get(part2)) {
                high = part1 - 1;
            } 
            else {
                /* find the median
                only two numbers will participate in the median, max of left part and min of right part. 
                if total number of records is odd, median will be max of left part, or it will be 
                average of [max of left, min of right] */
                
                int max;
                if (part1 == 0) {
                    max = B.get(part2 - 1);
                }
                else if (part2 == 0) {
                    max = A.get(part1 - 1);
                } 
                else {
                    max = Math.max(A.get(part1-1), B.get(part2-1));
                }
    
                if((m+n)%2 == 1 ){
                    return (double)max; 
                }
    
                //case when number of elements is even
                int min;
                if (part1 == m) {
                    min = B.get(part2);
                } 
                else if (part2 == n) {
                    min = A.get(part1);
                } 
                else {
                    min = Math.min(A.get(part1), B.get(part2));
                }
    
                return (double)(max + min)/2;
            }
    	}
    	return 0;
	}
}

//Second Method
public class Solution {
public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
	    int len = A.size() + B.size();
	    if(len % 2 == 1) return findKth(A, 0, B, 0, len / 2 + 1);
	    else return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
	}
	
	public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
	    if(A_start >= A.size()) return B.get(B_start + k - 1);
	    if(B_start >= B.size()) return A.get(A_start + k - 1);
	    if(k == 1) return Math.min(A.get(A_start), B.get(B_start));
	    
	    int A_key = A_start + k / 2 - 1 < A.size() ? A.get(A_start + k / 2 - 1) : Integer.MAX_VALUE;
	    int B_key = B_start + k / 2 - 1 < B.size() ? B.get(B_start + k / 2 - 1) : Integer.MAX_VALUE;
	    
	    if(A_key < B_key){
	        return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
	    }
	    else
	       return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
	}
}
