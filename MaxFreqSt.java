/* Maximum Frequency stack
Problem Description:
You are given a matrix A which represent operations of size N x 2. Assume initially you have a stack-like data structure 
you have to perform operations on it.
Operations are of two types:
1 x: push an integer x onto the stack and return -1
2 0: remove and return the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the 
operation performed.
Problem Constraints:
1 <= N <= 100000
1 <= A[i][0] <= 2
0 <= A[i][1] <= 109
Input Format:
The only argument given is the integer array A.
Output Format:
Return the array of integers denoting answer to each operation.
Example Input:
Input 1:
A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:
 A =  [   
        [1, 5]
        [2 0]
        [1 4]   ]
Example Output:
Output 1:
 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:
 [-1, 5, -1]
*/

public class MaxFreqSt {
    HashMap<Integer, Integer> fmap  = new HashMap<>();
    List<Stack<Integer>> stack  = new ArrayList<>();
    public int[] solve(int[][] A) {
        int[] ans = new int[A.length];
        int maxfreq = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i][0] == 1) {
                ans[i] = -1;
                push(A[i][1]);
            } 
            else {
                ans[i] = pop();
            }
        }
        return ans;
    }
    public void push(int x) {
        int freq = fmap.getOrDefault(x, 0) + 1;
        fmap.put(x, freq);
        if (freq == stack.size()+1) 
            stack.add(new Stack());
        stack.get(freq-1).add(x);
    }

    public int pop() {
        Stack<Integer> top = stack.get(stack.size()-1);
        int x = top.pop();
        if (top.size() == 0) stack.remove(stack.size()-1);
        fmap.put(x, fmap.get(x) - 1);
        return x;
    }
}