class Solution {
    public int maxNonOverlapping(int[] arr, int k) {
        int ans =0;
      long sum =0;
      Map<Long,Integer> mp = new HashMap<>();
      int prev  = -1;
      mp.put(sum,0);
      for(int i=0;i<arr.length;i++)
      {
        sum+=arr[i];
        if(mp.containsKey(sum-k))
           {
             ans++;
             sum =0;
          mp=new HashMap<>();
           }
      
          mp.put(sum,i+1);
      }
      return ans;
    }
}