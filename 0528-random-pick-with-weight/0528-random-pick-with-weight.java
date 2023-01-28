// import java.lang.*;
class Solution {
  
   TreeMap<Double,Integer> mp = new TreeMap<>();
    public Solution(int[] w) {
        double arr[]= new double[1];
        arr=new double[w.length];
      long sum =0;
      for(int i:w)
        sum+=i;
      for(int i=0;i<arr.length;i++)
        arr[i]=(double)w[i]/(double)sum;
      double pref[]= new double[arr.length];
      pref[0]=arr[0];
      for(int i=1;i<arr.length;i++)
      {
        pref[i]=pref[i-1]+arr[i];
      }
     
      for(int i=0;i<arr.length;i++)
        mp.put(pref[i],i);
      // System.out.println(mp);
    }
    
    public int pickIndex() {
       double rand = Math.random();      
      Double d = mp.lowerKey(rand);
      // 
      if(d!=null)
      return mp.get(d)+1;
      return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */