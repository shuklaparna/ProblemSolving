/* Largest Number Array Sort
https://leetcode.com/problems/largest-number/solution/
TC: O(N); SC: O(1) */

//First Method
public class LarNumArr {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public String largestNumber(final int[] A) {
        
        if(A.length==0)
            return "";
            
        String sa[] = new String[A.length];
        for(int i = 0; i < A.length; i++) {
            sa[i] = Integer.toString(A[i]);
        }
        
        Arrays.sort(sa,new Comparator<String> (){
            
            public int compare(String a, String b){
                String s1 = a+b;
                String s2 = b+a;
                return s2.compareTo(s1);
            }
        });
        
 
        if(sa[0].equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s:sa)
            sb.append(s);
        
        return sb.toString();
    }
}

//Second Method
public class Solution {
	// DO NOT MODIFY THE LIST
	public String largestNumber(final List<Integer> A) {
	    StringBuffer strBuf = new StringBuffer();
	    Node num[];
	    int i = 0;
	    
	    num = new Node[A.size()];
	    
	    for (int n : A) {
	        num[i] = new Node(n);
	        i++;
	    }
	    
	    Arrays.sort(num);
	    
	    for (Node n : num) {
	        if (n.number == 0 && strBuf.length() != 0)
	            continue;
	        strBuf.append(n.number);
	    }

	    
	    return strBuf.toString();
	}
	
	class Node implements Comparable<Node> {
	    
	    int number;
	    
	    public Node(int number) {
	        this.number = number;
	    }
	    
	    @Override
	    public int compareTo(Node o) {
	        String first = String.valueOf(this.number) + String.valueOf(o.number);
	        String second = String.valueOf(o.number) + String.valueOf(this.number);
	        
	        return second.compareTo(first);
	    }
	    
	}
}