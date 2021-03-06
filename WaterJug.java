/* Water&Jug
https://leetcode.com/problems/water-and-jug-problem/
TC: O(N); SC: O(1) */

class WaterJug {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z>x+y)return false;
        if(z==x||z==y)return true;
        
        int max=Math.max(x,y);
        int min=Math.min(x,y);
        if(min==0)return max==z;
        int mod=max%min;
        
        Set<Integer>set=new HashSet<>();
        while(!set.contains(mod)){
            if(z-mod>=0&&((z-mod)%min)==0){
                return true;
            }
            set.add(mod);
            mod=(max-(min-mod))%min;
        }
   
        return false;
    }
}