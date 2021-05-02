/* DiffK2
https://www.interviewbit.com/problems/diffk-ii/
TC: O(N); SC: O(N); */

//First Method - using HashSet
public class DiffK2 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] A, int B) {
        if(A.length == 1)
            return 0;
        HashSet<Integer> hset = new HashSet<Integer>();
        for(int i = 0; i < A.length; i++) {
            if(hset.contains(A[i] - B))
                return 1;
            else if(hset.contains(A[i] + B))
                return 1;
            else
                hset.add(A[i]);
        }
        return 0;
    }
}

//Second Method - using HashMap
public class Solution {
	public int diffPossible(final List<Integer> A, int B) {
	    HashMap<Integer, Integer> hashMap = new HashMap<>();
	    for (int num : A) {
	        if (hashMap.containsKey(num)) {
	            int value = hashMap.get(num);
	            value++;
	            hashMap.put(num, value);
	        } else {
	            hashMap.put(0, 1);
	        }
	    }
	    for (int num : A) {
	        int n = B + num;
	        if (hashMap.containsKey(n)) {
	            if (num == n && hashMap.get(n) > 1)
	                return 1;
	            else if (num != n)
	                return 1;
	        }
	        n = num - B;
	        if (hashMap.containsKey(n)) {
	            if (num == n && hashMap.get(n) > 1)
	                return 1;
	            else if (num != n)
	                return 1;
	        }
	    }
	    return 0;
	}
}