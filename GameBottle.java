/* Game of Bottles
https://www.geeksforgeeks.org/minimum-number-of-bottles-visible-when-a-bottle-can-be-enclosed-inside-another-bottle/
TC: O(N); SC: O(1) */

//FirstMethod
public class GameBottle {
    public int solve(int[] A) {
        Arrays.sort(A);
        int c = 1;
        int res = -1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1])
                c++;
            else {
                res = Math.max(res, c);
                c = 1;
            }
        }
        res = Math.max(res, c);
        return res;
    }
}

//SecondMethod
public class Solution {
    public int solve(int[] A) {
        int count=0;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        Arrays.sort(A);
        
        for(int i=0; i<A.length; i++) {
            Integer x = map.get(A[i]);
            if(x==null)
                map.put(A[i], 1);
            else
                map.put(A[i],x+1);
        }

        for(Integer i : map.keySet()) {
            Integer x = map.get(i); 
            count = Math.max(count, x);
        }
        return count;
    }
}
