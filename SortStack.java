/* Sort stack using another stack
Problem Description:
Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.
Problem Constraints:
1 <= |A| <= 5000
0 <= A[i] <= 1000000000
Input Format:
The only argument given is the integer array A.
Output Format:
Return the array of integers after sorting the stack using another stack.
Example Input:
 A = [5, 4, 3, 2, 1]
Example Output:
 [1, 2, 3, 4, 5] */
 
//First Solution
public class SortStack {
    public int[] solve(int[] A) {
        Stack<Integer> input = new Stack<Integer>();
        for(int i = 0; i < A.length; i++)
            input.add(A[i]);
         Stack<Integer> tmpStack = new Stack<Integer>();
            while(!input.isEmpty()) {
            // pop out the first element
            int tmp = input.pop();
          
            // while temporary stack is not empty and
            // top of stack is greater than temp
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                // pop from temporary stack and 
                // push it to the input stack
                input.push(tmpStack.pop());
            }
              
            // push temp in tempory of stack
            tmpStack.push(tmp);
        }
        int ans[] = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            ans[i] = tmpStack.get(i);
        }
        return ans;
    } 
}

//Second Method
public class Solution {
    public int[] solve(int[] A) {

       if(A.length<=1) return A;
      
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> helper = new Stack<Integer>();
        for(int i=0;i<A.length;i++){
            s1.push(A[i]);
        }
        
        while(!s1.empty()){
            int temp = s1.peek();
            s1.pop();
            while(!helper.empty() && helper.peek()>temp){
                s1.push(helper.peek());
                helper.pop();
            }
            helper.push(temp);
        }
        while(!helper.empty()){
            s1.push(helper.peek());
            helper.pop();
        }
        
        int ans[] = new int[A.length], i = 0;
        while(!s1.empty()){
            ans[i] = s1.peek();;
            s1.pop();
            i++;
        }
        
        return ans;
    }
}
