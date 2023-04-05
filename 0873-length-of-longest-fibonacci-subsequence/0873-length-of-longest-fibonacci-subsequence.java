class Solution {
    public int lenLongestFibSubseq(int[] arr) {
      Map<Integer,Integer> mp = new HashMap<>();
      int dp[][]= new int[arr.length][arr.length];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      for(int i=0;i<arr.length;i++)
        mp.put(arr[i],i);
        int a =  call(-1,-1,arr,mp,dp);
      return a==0?0:a+2;
    }
    public int call(int i, int j,int[] arr,Map<Integer,Integer> mp,int[][] dp)
    {
      int a = 0;
       if(i!=-1 && j!=-1)
       {
         if(dp[i][j]!=-1)
           return dp[i][j];
          if(mp.containsKey(arr[i]+arr[j]))
            a = 1+call(j,mp.get(arr[i]+arr[j]),arr,mp,dp);
         // return a;
       }
      else
      {
         for(int i1=0;i1<arr.length;i1++)
         {
           for(int j1=i1+1;j1<arr.length;j1++)
           {
             a = Math.max(a,call(i1,j1,arr,mp,dp));
           }
         }
        return a;

      }
      return dp[i][j]=a;
    }
}