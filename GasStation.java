/* Gas Station
https://www.interviewbit.com/problems/gas-station/
https://leetcode.com/problems/gas-station/
TC: O(N); SC: O(1) */

//First Method
public class GasStation {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int AGas = 0, BCost = 0;
        int start = 0, tank = 0;
        for (int i = 0; i < A.length; i++) {
            AGas += A[i];
            BCost += B[i];
            tank += A[i] - B[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (AGas < BCost) {
            return -1;
        } 
        else {
            return start;
        }
    }
}

//Second Method
public class Solution {
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
	    int n;
	    int petrol = 0;
	    int i;
	    int min = 0;
	    int temp = 0;
	    int lastPos = 0;
	    n = gas.size();
	    for (i = 0; i < n; i++) {
	        petrol += gas.get(i);
	        petrol -= cost.get(i);
	        lastPos = Math.max(petrol, gas.get(i) - cost.get(i) + lastPos);
	        if (lastPos >= 0) {
	            if (min == -1)
    	            min = i;
	        } 
			else {
	            min = -1;
	        }
	        lastPos = Math.max(0, lastPos);

	    }
	    if (petrol < 0)
	        return -1;
			
	    return min;
	}
}
