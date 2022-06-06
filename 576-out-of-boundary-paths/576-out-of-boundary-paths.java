class Solution {
    public int findPaths(int m, int n, int rem, int r, int c) {
        int dp[][][] = new int[m][n][rem+3];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                for(int k=0;k<rem+3;k++)
                dp[i][j][k]=-1;
        return call(m,n,rem,r,c,dp);
        
            }
    public int call(int m, int n,int rem, int i, int j,int[][][] dp)
    {
        if(i<0||j<0||i==m||j==n)
            return 1;
        if(rem ==0)
            return 0;
        if(dp[i][j][rem]!=-1)
            return dp[i][j][rem];
        int a1 = call(m,n,rem-1,i-1,j,dp)%(1000000007);
        int a2 = call(m,n,rem-1,i+1,j,dp)%(1000000007);
        int a3 = call(m,n,rem-1,i,j+1,dp)%(1000000007);
        int a4 = call(m,n,rem-1,i,j-1,dp)%(1000000007);
        return dp[i][j][rem]=((a1+a2)%(1000000007)+(a3+a4)%(1000000007))%(1000000007);
    }
}