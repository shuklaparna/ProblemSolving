/* Sort By Color
https://leetcode.com/problems/sort-colors/
TC: O(N); SC: O(1) */

//First Method
public class SortColor {
    public int[] sortColors(int[] A) {
        int p1 = 0, p2 = 0, p3 = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == 0) 
                p1++;
            else if(A[i] == 1) 
                p2++;
            else 
                p3++;
        }
        int k = 0;
        while(p1 != 0){
            A[k++] = 0;
            p1--;
        }
        while(p2 != 0){
            A[k++]=1;
            p2--;
        }
        while(p3 != 0){
            A[k++]=2;
            p3--;
        }
        return A;
    }
}

//Second Method
public class Solution {
	public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
	    
	    int zero = 0;
	    int two = A.size() - 1;
	    
	    for (int i = 0; i <= two;) {
	        if (A.get(i) == 0) {
	            int temp = A.get(zero);
	            A.set(zero, 0);
	            A.set(i, temp);
	            zero++;
	            i++;
	        } else if (A.get(i) == 2) {
	            int temp = A.get(two);
	            A.set(two, 2);
	            A.set(i, temp);
	            two--;
	        } else {
	            i++;
	        }
	    }
	    return A;
	}
}