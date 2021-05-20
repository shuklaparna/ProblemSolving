/* Longest Consecutive Sequence
https://www.interviewbit.com/problems/longest-consecutive-sequence/ */

//FirstMethod (less time)
public class LongConSeq {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) 
    {
        if(A.length==0)
            return 0;
        if(A.length==1)
            return 1;
        Set<Integer>hs=new HashSet<Integer>();
        for(int i=0;i<A.length;i++)
        {
            hs.add(A[i]);
        }
        int max=1;
        for(int e:A)
        {
            int left=e-1;
            int right=e+1;
            int count=1;
            while(hs.contains(left))
            {
                count++;
                hs.remove(left);
                left--;
            }
            while(hs.contains(right))
            {
                count++;
                hs.remove(right);
                right++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}

//SecondMethod (more time)
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        Set<Integer> B = new HashSet<Integer>();
        for(Integer i : A) {
            B.add(i);
        }
        int count = 0, max = 0;
        for(int i = 0; i < A.size(); i++) {
            count = 0;
            if(!(B.contains(A.get(i)-1))) {
                int j = A.get(i);
                while(B.contains(j+1)) {
                    count++;
                    j++;
                }
                if(max < (count+1)) {
                    max = (count+1);
                }
            }
        }
        return max;
    }
}

//ThirdMethod (less time)
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
    
        int maxCount = 0;
        for(int ele : A){
            if(hMap.get(ele) == null){
                int lCount = 0;
                int rCount = 0;
                if(hMap.get(ele-1) != null){
                    lCount = hMap.get(ele-1);
                }
                if(hMap.get(ele+1) != null){
                    rCount = hMap.get(ele+1);
                }
                
                hMap.put(ele, lCount + 1 + rCount);
                
                hMap.put(ele - lCount, hMap.get(ele));
                hMap.put(ele + rCount, hMap.get(ele));
                
                if(maxCount < lCount+1+rCount) maxCount = lCount+1+rCount;
            }
        }
        
        return maxCount;
    }
}


