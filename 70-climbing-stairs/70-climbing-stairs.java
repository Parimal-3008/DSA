class Solution {
    public int climbStairs(int n) {
        int dp[]= new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            if(i==2){
                dp[i]=2;continue;}
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
        // Arrays.fill(dp,-1);
        // return call(dp,n);
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