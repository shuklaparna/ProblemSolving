/* Points on the Straight Line
https://www.interviewbit.com/problems/points-on-the-straight-line/
TC: O(N); SC: O(N) */

public class PtsStLine {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        
        int n = a.size();
        
        if(n<2) return n;
        
        HashSet<Point> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < n ; i++){
            Point p1 = new Point(a.get(i), b.get(i));
            
            // proceed if we have not seen point
            if(!set.contains(p1)){
                
                int same = 0;
                // map to store slope of all lines that passes through p1
                HashMap<String, Integer> map = new HashMap<>();
                int localMax = 1;
                
                for(int j = i + 1 ; j < n ; j++){
                    Point p2 = new Point(a.get(j), b.get(j));
                    
                    if(p2.equals(p1)){
                        same++;
                        continue;
                    }
                    
                    String slope = getSlope(p1, p2);
                    map.put(slope, map.getOrDefault(slope,1)+1);
                    localMax = Math.max(localMax, map.get(slope));
                }
                set.add(p1);
                max = Math.max(max, localMax+same);
            }
        }
        
        return max;
    }
    
    // custom point class with overridden hashCode and equals so we can use
    // it with Collections.
    class Point{
        public int x;
        public int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object ob){
            if(ob instanceof Point){
                Point p1 = (Point)ob;
                return this.x == p1.x && this.y == p1.y;
            }
            return false;
        }
        
        public int hashCode(){
            return (this.x+"-"+this.y).hashCode();
        }
    } 
    
    //calculate slope in irrational number, we can use float or double 
    //but precision will effect comparing two double or float value
    //consider this 0.999999999 != 1.000000000
    public String getSlope(Point p1, Point p2){
        if(p1.x == p2.x) return "-INF";
        
        if(p1.y == p2.y) return "0";
        
        long xdiff = (long)p1.x - (long)p2.x;
        long ydiff = (long)p1.y - (long)p2.y;
        
        long g = gcd(Math.abs(xdiff), Math.abs(ydiff));
        
        //handling sign as -2/-3 is same as 2/3
        String sign = ((ydiff < 0 && xdiff < 0) || ( ydiff > 0 && xdiff > 0)) ? "" : "-";
        
        return sign+(Math.abs(ydiff)/g)+"/"+(Math.abs(xdiff)/g);
    }
    
    // gcd euclid's algorithm
    public long gcd (long a, long b){
        if( a < b ) return gcd(b,a);
        
        if(b == 0) return a;
        
        return gcd(b, a%b);
    }
}