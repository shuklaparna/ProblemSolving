/* Sub-array with 0 sum
https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
TC: O(N); SC: O(N) */

//First Method
public class SubArrSumZ {
    public int solve(int[] arr) {
        Set<Long> hs = new HashSet<Long>();
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
 
            if (arr[i] == 0 || sum == 0 || hs.contains(sum))
                return 1;
                
            hs.add(sum);
        }
        return 0;
    }
}

//Second Method
public class Solution {
    public int solve(ArrayList<Integer> A) {
        
        HashMap<Long, Long> mp = new HashMap<Long, Long>();
        
        long sum = 0;
        mp.put(sum, new Long(1));
        for(int x:A){
            sum += x;
            if(mp.get(sum) != null) return 1;
            else
            {
                mp.put(sum, new Long(1));
            }
        }
        
        return 0;
        
    }
}