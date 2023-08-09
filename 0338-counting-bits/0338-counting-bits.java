class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=n;i>=0;i--)
        {
            if(dp[i]==-1)
                dp[i]=call(i,dp);
        }
         return dp;
    }
    public int call( int n, int[] dp)
    {
        if(n==1)
        return n;
        if(dp[n]!=-1)
            return dp[n];
        int p = (int)((double)Math.log((double)n)/(double)Math.log(2.0));
        if((int)Math.pow(2,p)==n)
            return dp[n] = 1;
        int rem = n- (int)Math.pow(2,p);
         // System.out.println(n+" "+p+" "+rem);
       
        return dp[n] = 1 + call(rem,dp);
    }
}