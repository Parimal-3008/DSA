class Solution {       
    public int minCost(int[] arr, int k) {
      int dp[][]= new int[arr.length+1][arr.length+1];
       int dp2[][]= new int[arr.length][arr.length];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      for(int i=0;i<arr.length;i++)
      {
         Map<Integer,Integer> mp = new HashMap<>();
        for(int j=i;j<arr.length;j++)
        {
          if(j==0)
          {
            mp.put(arr[j],1);
            dp2[i][j]=0;
            continue;
          }
          if(mp.containsKey(arr[j]))
          {
            int val = mp.get(arr[j]);
            if(val==1)
            {
              dp2[i][j]=dp2[i][j-1]+2;
            }
            else
            {
               dp2[i][j]=dp2[i][j-1]+1;
            }
            mp.put(arr[j],val+1);            
          }
          else
          {
            dp2[i][j]=dp2[i][j-1];
            mp.put(arr[j],1);
          }
        }
      }
             return call(arr,0,0,k,dp,dp2);
    }
  public int call(int[] arr, int i, int prev, int k,int[][] dp,int[][] dp2)
  {
    if(i== arr.length)
    {
       int b = k+ dp2[prev][i-1];
       return b;
    }
    if(dp[i][prev]!=-1)
      return dp[i][prev];
    int a = call(arr,i+1,prev,k,dp,dp2);
    int b =Integer.MAX_VALUE;
    if(i-1>=0)
      b= dp2[prev][i-1]+k + call(arr,i+1,i,k,dp,dp2);
     return dp[i][prev] =  Math.min(a,b);
    
  }
}