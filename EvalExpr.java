/* Evaluation of Expression
https://www.interviewbit.com/problems/evaluate-expression/
https://leetcode.com/problems/evaluate-reverse-polish-notation/
TC: O(N); SC:O(1); */

import java.util.Stack;
public class EvalExpr {
public int evalRPN(String[] A) {

    Stack<Integer> s1=new Stack<Integer>();
    
    for(int i=0;i<A.length;i++)
    {
        String c=A[i];
        
          
        
         if(c.equals("*"))
        {
           int a=s1.pop();
           int b=s1.pop();
            s1.push(a*b);
        }
       else if(c.equals("+"))
        {
            int a=s1.pop();
            int b=s1.pop();
            s1.push(a+b);
        }
       else if(c.equals("/"))
        {
           int a=s1.pop();
           int b=s1.pop();
           s1.push(b/a);
        }
      else if(c.equals("-"))
        {
           int a=s1.pop();
           int b=s1.pop();
           s1.push(b-a);
        }
        else
        {
              s1.push(Integer.parseInt(c));
        }
        
        
    }
    return s1.peek();
	}
}