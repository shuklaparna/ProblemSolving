/* N integers containing only 1, 2 & 3
Problem Description:
Given an integer A. Find and Return first positive A integers in ascending order containing only digits 1, 2 and 3.
NOTE: All the A integers will fit in 32 bit integer.
Problem Constraints:
1 <= A <= 29500
Input Format:
The only argument given is integer A.
Output Format:
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
Example Input:
Input 1:
 A = 3
Input 2:
 A = 7
Example Output:
Output 1:
 [1, 2, 3]
Output 2:
 [1, 2, 3, 11, 12, 13, 21] */

//First Method
public class Num123 {
    public int[] solve(int A) {
        Queue<Integer> q = new LinkedList<Integer>();
		int[] ans = new int[A];
        q.add(1);
        q.add(2);
        q.add(3);
        for(int i = 0; i < A; i++){
            int x = q.remove();
            ans[i] = x;
            q.add(10*x+1);
            q.add(10*x+2);
            q.add(10*x+3);
        }
        return ans;
    }
}

//Second Method
public class Solution {
    public int[] solve(int A) {
        if(A == 1) 
            return (new int[]{1});
        int[] ans = new int[A];
        int c = 0;
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        q.add("3");
        for(int i = 2; i <= A/2; i++) {
            String s = q.remove();
            ans[c++] = Integer.parseInt(s);
            q.add(s.concat("1"));
            q.add(s.concat("2"));
            q.add(s.concat("3"));
        }
        for(int i = c; i < A; i++) {
            ans[i] = Integer.parseInt(q.remove());
        }
        return ans;
    }
}
