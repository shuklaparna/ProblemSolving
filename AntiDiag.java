/* Anti Diagonals
https://www.interviewbit.com/problems/anti-diagonals/
TC: O(N) */
public class AntiDiag {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> arr) {
        /*int N = 2 * A.size() - 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for(int i = 0; i < a.size()*2-1; i++)
	        res.add(new ArrayList<Integer>());
	        
	    for(int i = 0; i < a.size(); i++){
	        for(int j = 0; j < a.get(0).size(); j++){
	            res.get(i+j).add(a.get(i).get(j));
	        }
	    }
	    
	    return res;*/

        int n=arr.size();
	    ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
	    if(n==0)
	    return res;
	    for(int i=0;i<=(2*(n-1));i++)
	    {
	        ArrayList<Integer> temp=new ArrayList<Integer>();
	        for(int j=0;j<=i;j++)
	        {
	            int dif=i-j;
	            if(j>=n || dif>=n)
	                continue;
	            temp.add(arr.get(j).get(dif));
	        }
	        //Collections.reverse(temp);
	        res.add(temp);
	    }
        return res;
    }
}
