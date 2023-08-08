class Solution {
    public int climbStairs(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return call(n,dp);
    }
    public int call(int n, int[] dp)
    {
        if(n<=2)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]= call(n-1,dp)+ call(n-2,dp);
    }
}