/* Rearrange Array - Math
https://www.interviewbit.com/problems/rearrange-array/
TC: O(N) */

public class ReArr {
	public void arrange(ArrayList<Integer> A) {
        int n = A.size();
	    for (int i = 0; i < n; i++) {
	        A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
	    }
	    for (int i = 0; i < n; i++) {
	        A.set(i, A.get(i) / n);
	    }
	}
}

