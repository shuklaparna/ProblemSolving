/* K Largest Elements
https://www.interviewbit.com/problems/k-largest-elements/
https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
TC: O(NlogN); O(B) */

class KLarEle {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(A);
        for(int i = A.size()-1; B != 0; i--) {
            ans.add(A.get(i));
            B--;
        }
        return ans;
    }
}
//Time Complexity: O(log(k) + (n-k)*log(k)) without sorted output. 
//If sorted output is needed then O(log(k) + (n-k)*log(k) + k*log(k))
public class Solution {
    public int[] solve(int[] A, int B) {
        int len = A.length;
        int[] arr = new int[B];
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(len, Collections.reverseOrder());
        for(int i=0; i<len; i++){
            q.offer(A[i]);
        }
        
        for(int i=0; i<B; i++){
            arr[i] = q.poll();
        }
        
        return arr;
    }
}