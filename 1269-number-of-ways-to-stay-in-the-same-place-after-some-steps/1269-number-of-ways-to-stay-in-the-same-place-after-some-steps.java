class Solution {
  int mod = 1000000007;
    public int numWays(int k, int n) {
      int dp[][]= new int[501][501];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      return call(0,k,n,dp);  
    }
  public int call(int i, int k, int n,int[][] dp)
  {
    if(k==0 && i==0)
      return 1;
    if(i==n)
      return 0;    
    if(k<0)
      return 0;
      int ans =0;   
      int a = 0;
      int b = 0;
      int c =0;
    
    if(dp[i][k]!=-1)
      return dp[i][k];
      if(i==0)
      {
        a = call(i+1,k-1,n,dp);
        b = call(i,k-1,n,dp);
      }
      else if(i==n-1)
      {
        a = call(i-1,k-1,n,dp);
        b = call(i,k-1,n,dp);
      }
      else
      {
        a = call(i-1,k-1,n,dp);
        b = call(i,k-1,n,dp);
        c = call(i+1,k-1,n,dp);
      }
      ans += (((a+b)%mod)+c)%mod;
      while(ans<0)
        ans+=mod;
    
    return dp[i][k]=ans;
  }
}