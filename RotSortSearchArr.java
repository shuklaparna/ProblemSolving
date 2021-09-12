/* Rotated Sorted Array Search
https://leetcode.com/problems/search-in-rotated-sorted-array/
https://www.interviewbit.com/problems/rotated-sorted-array-search/
O(nlogN) */
public class RotSortSearchArr {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] a, int target) {
        int low = 0, high = a.length - 1; 
        while(low <= high) {
            int mid = (low + high) / 2; 
            if(a[mid] == target) return mid; 
            
            // the left side is sorted
            if(a[low] <= a[mid]) {
                if(target >= a[low] && target <= a[mid]) {
                    high = mid - 1; 
                }
                else {
                    low = mid + 1; 
                }
            }
            else {
                if(target >= a[mid] && target <= a[high]) {
                    low = mid + 1; 
                }
                else {
                    high = mid - 1; 
                }
            }
        } 
        return -1;
    }
}

