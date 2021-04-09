/* Intersection of 2 arrays
https://leetcode.com/problems/intersection-of-two-arrays-ii/
TC: O(min(A.size(), B.size())); SC: O(1)
 */
 //First Method
public IntersectArr {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int p1 = 0, p2 = 0;
        Collections.sort(A);
        Collections.sort(B);
        while(p1 < A.size() && p2 < B.size()) {
            if(A.get(p1).intValue() == B.get(p2).intValue()) {
                arr.add(A.get(p1));
                p1++;
                p2++;
            }
            else if(A.get(p1) < B.get(p2)) {
                p1++;
            }
            else {
                p2++;
            }
        }
    return arr;
    }
}

 //Second Method
class Solution {
    public int[] intersect(int[] A, int[] B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int p1 = 0, p2 = 0, c = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        while(p1 < A.length && p2 < B.length) {
            if(A[p1] == B[p2]) {
                ans.add(A[p1]);
                p1++;
                p2++;
            }
            else if(A[p1] < B[p2]) {
                p1++;
            }
            else {
                p2++;
            }
        }
    
    return (convertIntegers(ans));
    }
    public static int[] convertIntegers(ArrayList<Integer> ans) {
		int[] ret = new int[ans.size()];
		for (int i=0; i < ret.length; i++) {
			ret[i] = ans.get(i);
		}
		return ret;
    }
}
