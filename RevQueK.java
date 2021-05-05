/* Reversing Elements Of Queue
https://www.geeksforgeeks.org/reversing-first-k-elements-queue/
TC: O(N); SC: O(N) */

//First Method
public class RevQueK {
    public int[] solve(int[] A, int B) {
        Deque<Integer> q = new ArrayDeque<Integer>(A.length);
        int i = 0;
        
        // Insert first B elements in queue
        for(i=0;i<B;i++)
            q.addLast(A[i]);
        // Reverse the first B elements in the array A
        while(q.size() > 0){
            A[--i] = q.removeFirst();
            
        }
    
        return A;
    }
}
         
//Second Method
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Queue<Integer> q = new LinkedList<>(A);
         Stack<Integer> st = new Stack<>();
         for(int i = 0; i < B; i++) {
             st.push(q.remove());
         }
         while (!st.empty()) {
            q.add(st.pop());
        }
        for (int i = 0; i < q.size()-B; i++) {
            q.add(q.remove());
        }
        ArrayList<Integer> list = new ArrayList<Integer>(q);
        return list;
    }
}