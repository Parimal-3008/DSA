class Solution {
    public int numTilings(int n) {
        long dp[]= new long[1001];
      dp[1]=1;dp[2]=2;dp[3]=5;dp[4]=11;
      for(int i=5;i<=1000;i++)
        dp[i]=(dp[i-1]+dp[i-1]+dp[i-3])%1000000007;
      return (int)dp[n];
      
    }
}