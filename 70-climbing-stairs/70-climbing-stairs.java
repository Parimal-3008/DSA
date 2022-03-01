class Solution {
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return call(dp,n);
    }
    public int call(int []dp, int n)
    {
        if(n<=2)
            return n;
         if(dp[n]!=-1)
             return dp[n];
        int l = call(dp,n-1);
        int r = call(dp,n-2);
        return dp[n]= l+r;
        
    }
}