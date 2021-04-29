/* Sixlets
Problem Description:
Given a array of integers A of size N and an integer B.
Return number of non-empty subsequences of A of size B having sum <= 1000.
Problem Constraints:
1 <= N <= 20
1 <= A[i] <= 1000
1 <= B <= N
Input Format:
The first argument given is the integer array A.
The second argument given is the integer B.
Output Format:
Return number of subsequences of A of size B having sum <= 1000.
Example Input:
Input 1:
    A = [1, 2, 8]
    B = 2
Input 2:
    A = [5, 17, 1000, 11]
    B = 4
Example Output:
Output 1:
3
Output 2:
0
Example Explanation:
Explanation 1:
 {1, 2}, {1, 8}, {2, 8}
Explanation 1:
 No valid subsequence */


//First Method
public class SixletSubseq {
    
    int sixlets(int a[], int i, int sum, int cnt) {
        if(sum > 1000)  return 0;
        if(cnt == 0)    return 1;
        if(i == a.length)   return 0;
        
        // Take ith element or leave it.   
        return sixlets(a, i+1, sum, cnt) + sixlets(a, i+1, sum + a[i], cnt-1);
    }
    
    public int solve(int[] A, int B) {
        return sixlets(A, 0, 0, B);
    }
}

//Second Method
public class Solution {
    int ans = 0;
    public int solve(int[] A, int B) {
        getans(A,B,0,0,0); 
        return ans; 
    }
    public void getans(int A[], int B,int siz, int sum, int index ) {
        if(sum > 1000) {
            return; 
        } 
        if(siz == B) { 
            if(sum <= 1000) { 
                ans++; 
            } 
            return; 
        } 
        if(index == A.length) {
            return; 
        } 
        for(int i = index; i < A.length; i++) {
            getans(A, B, siz+1, sum + A[i], i+1); 
            
        }
    }
}
