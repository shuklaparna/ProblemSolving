/* N integers containing only 1, 2 
Problem Description:
Given an integer A, you have to find the Ath Number with following rules-
*It comprises only 1 and 2.
*The number of digits in a number is even.
*It is a palindrome number. 
For example 11, 22, 112211 are numbers, where 123, 121, 782, 1 are not.
Problem Constraints:
1 <= A <= 100000
Input Format:
The only argument given is an integer A.
Output Format:
Return a string that denotes the Ath Number.
Example Input:
 A = 3
Example Output:
 1111
Example Explanation:
First four numbers are:
1. 11
2. 22
3. 1111
4. 1221 */

public class Num12 {
    public String solve(int A) {
        if(A==1) 
            return "11";
        else if(A==2) 
            return "22";
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        for(int i = 2; i <= A; i++) {
            String x = q.remove();
            q.add(x.concat("1"));
            q.add(x.concat("2"));
        }
        String a = q.remove();
        StringBuilder sb = new StringBuilder(a); 
        sb.reverse();
        a += sb.toString();
    return a;
    }
}
