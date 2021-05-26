/* Rain Water Trapped
https://www.interviewbit.com/problems/rain-water-trapped/
https://www.geeksforgeeks.org/trapping-rain-water/
https://leetcode.com/problems/trapping-rain-water/
TC: O(N); SC: O(N) */

public class RainTrap {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int trap(final int[] A) {
        int n = A.length;
        int ans = 0;
        Stack<Integer> s = new Stack<>();;
        s.push(A[0]);
        int ma = A[0];
        for(int i=1;i<n;i++){
            if(A[i]<ma) s.push(A[i]);
            else{
                while(!s.empty()){
                    ans+=ma-s.peek();
                    s.pop();
                }
                s.push(A[i]);
                ma = A[i];
            }
        }
        ma = 0;
        while(!s.empty()){
            ma = Math.max(ma,s.peek());
            ans+=ma-s.peek();
            s.pop();
        }
        return ans;
    }
}

