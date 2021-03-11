/*Search for a Range
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Time Complexity: O(logN + logN) */

public class SearchRange {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int P1 = -1, P2 = -1;
        int[] ind = new int[2];
        int n = A.length;
        int l, h;
        //for First Index of Occurrence
        for(l = 0, h = n-1; l <= h;) {
            int mid = (l + h) / 2;
            if(A[mid] == B) {
                P1 = mid;
                h = mid - 1;
            }
            else if(A[mid] > B) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        //for Last Index of Occurrence
        for(l = 0, h = n-1; l <= h;) {
            int mid = (l + h) / 2;
            if(A[mid] == B) {
                P2 = mid;
                l = mid + 1;
            }
            else if(A[mid] > B) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        ind[0] = P1;
        ind[1] = P2;
        return ind;
    }
}
