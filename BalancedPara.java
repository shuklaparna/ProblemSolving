/* Balanced Paranthesis
https://leetcode.com/problems/valid-parentheses/
https://www.interviewbit.com/problems/balanced-parantheses/
TC: O(1); SC: O(N) */

public class BalancedPara {
    public int solve(String A) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (map.containsKey(c)) {
                st.push(st.get(c));
            } else if (map.containsValue(c)) {
                if (st.isEmpty() || st.pop() != c) {
                    return 0;
                }
            }
        }
        return 1;
 
    }
    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    
}
