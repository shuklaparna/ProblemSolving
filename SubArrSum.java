/* Subarray with given sum
TC: O(NlogN); SC: O(N)
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
If the answer does not exist return an array with a single element "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".

Example Input: 
 A = [1, 2, 3, 4, 5]
 B = 5
Example Output:
[2, 3]
Example Explanation
 [2, 3] sums up to 5.
 */

public class SubArrSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        ArrayList<Integer> C = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(Integer i: A) {
            C.add(i);
        }
        if(A.get(0) == B) {
            ans.add(A.get(0));
            return ans;
        }
        for(int i = 1; i < n; i++) {
            A.set(i, (A.get(i-1) + A.get(i)));
            if(A.get(i) == B) {
                for(int j = 0; j <= i; j++) {
                    ans.add(C.get(j));
                }
                return ans;
            }
        }
    
        int p1 = 0, p2 = 1;
        while(p2 < n) {
            int diff = A.get(p2) - A.get(p1);
            if(diff < B) {
                p2++;
            }
            else if(diff > B) {
                p1++;
            }
            else {
                for(int j = p1+1; j <= p2; j++) {
                    ans.add(C.get(j));
                }
                return ans;
            }
        }
        
        ans.add(-1);
        return ans;
  
    }
}
