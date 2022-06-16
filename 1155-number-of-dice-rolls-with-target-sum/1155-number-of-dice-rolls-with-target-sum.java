class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n][target+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return call(0,n,k,target,dp);
    }
    int mod = 1000000007;
    public int call(int i, int n,int k, int target,int[][] dp)
    {
       
        if (i==n && target == 0)
            return 1;     
        if(i==n|| target<0)
            return 0;
        int ans=0;
        if(dp[i][target]!=-1)
            return dp[i][target];
        for(int j=01;j<=k;j++)
        {

            ans = (ans+(call(i+1,n,k,target-j,dp))%mod)%mod;
        }
        //System.out.println(ans);
        return dp[i][target]=(ans);
    }
}