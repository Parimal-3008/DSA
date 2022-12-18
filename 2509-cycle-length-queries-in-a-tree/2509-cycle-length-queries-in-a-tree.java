class Solution {
  
    public int[] cycleLengthQueries(int n, int[][] arr) {
        int ans[]= new int[arr.length];
      for(int i=0;i<arr.length;i++)
      {
        Map<Integer,Integer> mp1 = new HashMap<>();
       call(arr[i][0],mp1,1);
        // System.out.println(mp1);
        ans[i]=call2(arr[i][1],mp1,1);
      }
      return ans;
    }
  public void call(int i,Map<Integer,Integer> mp, int curr)
  {
    if(i==0)
      return;
    mp.put(i,curr);
    call(i/2,mp,curr+1);
    
  }
   public int call2(int i,Map<Integer,Integer> mp, int curr)
   {
     if(mp.containsKey(i))
        return mp.get(i)+curr-1;
        return call2(i/2,mp,curr+1);
       
   }
}