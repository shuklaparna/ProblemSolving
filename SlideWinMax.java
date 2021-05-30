/* Sliding Window Maximum
https://www.interviewbit.com/problems/sliding-window-maximum/
https://leetcode.com/problems/sliding-window-maximum/
TC: O(n); SC: O(n) */
//Interviewbit Soln
public class SlideWinMax {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> max = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i = 0; i < B && i < A.size(); i++){
            int v = A.get(i);

            while(!q.isEmpty() && A.get(q.peekLast()) <= v){
                q.removeLast();
            }
            q.addLast(i);
        }

        max.add(A.get(q.peekFirst()));
        while(i < A.size()){
            if(!q.isEmpty() &&  (i- q.peekFirst()) >= B){
                q.removeFirst();
            }

            int temp = A.get(i);
            while(!q.isEmpty() && A.get(q.peekLast()) <= temp){
                q.removeLast();
            }
            q.addLast(i);
            max.add(A.get(q.peekFirst()));
            i++;
        }

        return max;
    }
}
//Leetcode Soln
class Solution {
     public int[] maxSlidingWindow(int[] a, int k) {
         Deque<Integer> q = new LinkedList<>();
        int[]op = new int[a.length-k+1];
        int i;
        for(i=0;i<k;i++)
        {
            while(!q.isEmpty() && a[i]>=a[q.peekLast()])
            {
                q.removeLast();
            }
            q.addLast(i);
        }
        int j =0;
        for(;i<a.length;i++)
        {
            op[j++] = a[q.peek()];
            while(!q.isEmpty() && q.peek()<=(i-k))
            {
                q.removeFirst();
            }
            while(!q.isEmpty() && a[i]>=a[q.peekLast()])
            {
                q.removeLast();
            }
            q.addLast(i);
        }
        op[j]= a[q.peek()];
        return op;
    }
}