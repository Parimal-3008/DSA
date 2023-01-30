class Solution {
  long mod = 1000000007L;
    public int countPaths(int[][] arr) {
      int m = arr.length;
      int n = arr[0].length;
      long dp[][]= new long[m][n];
      for(long i[]:dp)
        Arrays.fill(i,-1L);
     long ans = 0;
      for(int i=0;i<m;i++)
      {
        for(int j=0;j<n;j++)
        {
           // ans = (ans +1 )%mod;
          if(dp[i][j]==-1)
          {
            ans = (ans%mod +  call(i,j,dp,arr)%mod) % mod;
           
          }
         
        }
      }
      ans =0;
      for(long i[]:dp)
      {
        
        for(long j:i)
        {
          ans = (ans + j)%mod;
          // System.out.print(j+" ");
        }
        // System.out.println();
      }
      return (int)ans;
      // return (int)dp[1][1];
    }
  public long call(int i, int j, long[][] dp, int[][] arr)
  {
    if(i<0 || j<0 || i==arr.length || j==arr[0].length)
      return 0;
    if(dp[i][j]!=-1)
      return dp[i][j];
    long a = 1;
    if(i-1>=0 && arr[i-1][j]>arr[i][j])
      a= ( a + call(i-1,j,dp,arr)%mod);
    if(j-1>=0 && arr[i][j-1]>arr[i][j])
      a= ( a + call(i,j-1,dp,arr)%mod);
    if(i+1<arr.length && arr[i+1][j]>arr[i][j])
      a= ( a+ call(i+1,j,dp,arr)%mod);
    if(j+1<arr[0].length && arr[i][j+1]>arr[i][j])
      a= (a+ call(i,j+1,dp,arr)%mod);
    return dp[i][j]=a;
    
  }
}