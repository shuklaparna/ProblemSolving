/* Colorful Number
https://www.interviewbit.com/problems/colorful-number/
TC: O(N^2); SC: O(N); */

public class ColorNum {
    public int colorful(int A) {
        HashSet<Integer> hset = new HashSet<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = A; i > 0; i/=10) {
            list.add(i % 10);
        }
        for(int i = 0; i < list.size(); i++) {
            if(hset.contains(list.get(i))) {
                return 0;
            }
            else {
                hset.add(list.get(i));
            }
        }
        for(int i = 0; i< list.size(); i++) {
			int mul = list.get(i);
			for(int j = i+1; j < list.size(); j++) {
                mul = mul * list.get(j);   
                if(hset.contains(mul)) {
                   return 0;
                }
                else {
                    hset.add(mul);
                }
            }
        }
        return 1;
        
    }
}
