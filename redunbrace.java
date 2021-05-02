/* Redundant Braces
https://www.interviewbit.com/problems/redundant-braces/
https://www.geeksforgeeks.org/expression-contains-redundant-bracket-not/
TC: O(N); SC: O(N); */

//FirstMethod
public class redunbrace {
  public int braces(String A) {
    Stack<Character> stack = new Stack<>();
    for (char c : A.toCharArray()) {
	// if current character is close parenthesis ')'
      if (c == ')') {
        char top = stack.pop();
		// If immediate pop have open parenthesis '(' duplicate brackets found
        if (top == '(') {
          return 1;
        }
        else {
          int count = 0;
          while (top != '(') {
            top = stack.pop();
            count++;
          }
          if (count == 1) {
            return 1;
          }
        }
      }
      else {
        stack.add(c);
      }
    }
    return 0;
  }
}

//SecondMethod
public class Solution {
    
    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public int braces(String A) {
        char s[] = A.toCharArray();
        int n = s.length;
        Stack <Character> st = new Stack<>();
        for(char c : s) {
            if(c == '(') {
                st.push(c);
            } 
			else if(c == ')') {
                char top = st.peek();
                if( !isOperator(top) )    
					return 1;
                while ( isOperator(st.peek()) )   
					st.pop();
                if(st.peek() != '(')    
					return 1;
                st.pop();
            } 
			else if(isOperator(c)) {
                st.push(c);
            }
        }
        while ( !st.isEmpty() && isOperator(st.peek()) )   st.pop();
        return st.isEmpty() ? 0 : 1;
    }
}