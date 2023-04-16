class Solution {
 
  long mod = 1000000007;
    public int numberOfPaths(int[][] arr, int k) {
      long dp[][][]= new long[arr.length][arr[0].length][k+1];
      for(long i[][]:dp)
        for(long j[]:i)
          Arrays.fill(j,-1);
      return (int)call(0,0,arr,k,0,dp);
    }
   public long call(int i, int j, int[][] arr, int k,int curr,long[][][] dp)
   {
     if(dp[i][j][curr]!=-1)
       return dp[i][j][curr];
     
     if(i==arr.length-1 && j == arr[0].length-1)
      {
       int  curr2= (curr+arr[i][j])%k;
        if(curr2==0)
          return 1;
        return 0;
      }
     
     long tot = 0;
      int  curr2= (curr+arr[i][j])%k;
     if(i+1<arr.length)
       tot=  (tot + call(i+1,j,arr,k,curr2,dp))%mod;
     if(j+1<arr[0].length)
       tot= (tot + call(i,j+1,arr,k,curr2,dp)) % mod;
     return dp[i][j][curr] = tot;
     
   }
}