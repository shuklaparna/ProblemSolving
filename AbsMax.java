/* Absolute maximum
Problem Description:
Given 4 array of integers A, B, C and D of same size. Find and return the maximum value of 
| A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j| 
where i != j and |x| denotes the absolute value of x.
Problem Constraints:
2 <= length of the array A, B, C, D <= 100000
-106 <= A[i] <= 106
Input Format:
The arguments given are the integer arrays A, B, C, D.
Output Format:
Return the maximum value of 
| A [ i ] - A [ j ] | + | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j|
Example Input:
Input 1:
 A = [1, 2, 3, 4]
 B = [-1, 4, 5, 6]
 C = [-10, 5, 3, -8]
 D = [-1, -9, -6, -10]
Input 2:
 A = [1, 2]
 B = [3, 6]
 C = [10, 11]
 D = [1, 6]
Example Output:
Output 1:
 30
Output 2:
 11
Example Explanation:
Explanation 1:
 Maximum value occurs for i = 0 and j = 1.
Explanation 2:
There is only one possibility for i, j as there are only two elements in the array. */
//TC: O(N); SC: O(N) 

//First Solution
public class AbsMax {
    public int solve(int[] A, int[] B, int[] C, int[] D) {
        int ans = Integer.MIN_VALUE; 
    	for(int i = 0; i < 16; i++){ 
    		ans = Math.max(ans, nextSet(i, A, B, C, D)); 
    	} 
	    return ans;
    }
    int nextSet(int n, int[] A, int[] B, int[] C, int[] D){ 
    	int arr[] = new int[4]; 
    	for(int i = 0; i < 4; i++){ 
    		if((n & 1) == 1)
    			arr[i] = 1; 
    		else 
    			arr[i] = -1; 
    		n >>= 1; 
    	}
    	int maxN = Integer.MIN_VALUE;
    	int minN = Integer.MAX_VALUE;
    	int total = 0; 
    	for(int i = 0; i < A.length; i++){ 
    		total = A[i];
    		total += (arr[0] * B[i]) + (arr[1] * C[i]) + (arr[2] * D[i]) + (arr[3] * i); 
    		maxN = Math.max(maxN, total); 
    		minN = Math.min(minN, total); 
    	} 
    	return maxN - minN; 
    }     
}

//SecondMethod
public class Solution {
        public int solve(int[] A, int[] B, int[] C, int[] D) {
        
        int m[] = new int[5];
        int d = 0, val = 0;
        int ans = 0;
        
        // Expand the given expression in 32 diiferent ways
        for(int i = 0; i < 32; i++) {
            
            for(int j = 0; j < 5; j++) {
                m[j] = ((i >> j) & 1);
                if(m[j] == 0)   m[j] = -1;
            }
            
            int Min = Integer.MAX_VALUE;
            int Max = Integer.MIN_VALUE;
            for(int k = 0; k < A.length; k++) {
                val = A[k] * m[0] + B[k] * m[1] + C[k] * m[2] + D[k] * m[3] + k * m[4];
                Max = Math.max(Max, val);
                Min = Math.min(Min, val);
            }
            ans = Math.max(ans, Max - Min);
        }
        
        return ans;
    }
}

