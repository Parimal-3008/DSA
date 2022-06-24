class Solution {
    public int twoEggDrop(int n) {
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        return call(2,n,n+1,dp);
    }
    public int call(int l, int r,int n,int[][] dp)
    {
        if(r<=1)
            return r;
        if(l==1)
            return r;
        if(dp[l][r]!=-1)
            return dp[l][r];
        int min= Integer.MAX_VALUE;
        for(int i=1;i<=r;i++)
        {
            int a =1+Math.max(call(l-1,i-1,n,dp),call(l,r-i,n,dp));
            //int b = r-i+call(i,r,n,dp);
            min = Math.min(min,a);
            
        }
        return dp[l][r]=min;
    }
}