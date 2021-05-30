/* Add One to Number
https://www.interviewbit.com/problems/add-one-to-number/
https://leetcode.com/problems/plus-one/
TC: O(N); SC: O(N)*/

//ArrayMethod
public class PlusOne {
    public int[] plusOne(int[] A) {
        int carry = 1, p = 0;
        for(int i = A.length-1; i >= p; i--){
            int sum = A[i] + carry;
            A[i] = sum % 10;
            carry = sum / 10;
        }
        if(carry>0){
            int b[] = new int[A.length+1];
            b[0] = carry;
            for(int i = 1; i < A.length+1; i++)
            b[i] = A[i-1];
            return b;
        }
        else {
          int pp = 0;
          while(A[pp]==0)
          pp++;
            int b[] = new int[A.length-pp];
            for(int i = pp; i < A.length; i++)
            b[i-pp] = A[i];
            return b;
        }
    }
}

//ArrayListMethod
public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int reminder = 0;
       while (A.size() > 1 && A.get(0) == 0) {
            A.remove(0);
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            int num = A.get(i);
            if(num == 9){
                A.remove(i);
                A.add(i,0);
                reminder = 1;
            }else{
                A.remove(i);
                A.add(i,num+1);
                reminder = 0;
                break;
            }
        }
        if(reminder == 1){
            A.add(0,1);
        }
        return A;
    }
}