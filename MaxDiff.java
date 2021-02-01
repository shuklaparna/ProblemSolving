/* Maximum Difference b/w two elements
https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
Time Complexity: O(n) */

public class MaxDiff {
    public int solve(int[] A) {
        int diff = A[1] - A[0]; 
        int min = A[0]; 
        
        for (int i = 1; i < A.length; i++) { 
            if (A[i] - min > diff) 
                diff = A[i] - min; 
            if (A[i] < min) 
                min = A[i]; 
        } 
        return diff; 
        
    }
}