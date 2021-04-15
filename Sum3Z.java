/* three sum zero
https://www.interviewbit.com/problems/3-sum-zero/
TC: O(N^2); SC: O(1) */

public class Sum3Z {
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
	    
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> temp = new ArrayList<>();
	    
	    if (A == null)
	        return res;
	    
	    Collections.sort(A);
	    int n = A.size();
	    
	    for (int low = 0; low < n - 2; low++) {
	        
	        int mid = low + 1;
	        int high = n - 1;
	        int sum = -A.get(low);
	        
	        if (low > 0 && A.get(low).intValue() == A.get(low - 1).intValue())
	            continue;
	        
	        while (mid < high) {
	            
	            int num = A.get(mid) + A.get(high);
	            
	            if (num == sum) {
	                temp.add(A.get(low));
	                temp.add(A.get(mid));
	                temp.add(A.get(high));
	                res.add(new ArrayList(temp));
	                temp.clear();
	                
	                int prev = mid;
	                while (mid <= high && A.get(mid).intValue() == A.get(prev).intValue())
	                    mid++;
	                    
	            } else if (num < sum) {
	                mid++;
	            } else {
	                high--;
	            }
	        }
	    }
	    
	    return res;
	    
	    
	}
}
