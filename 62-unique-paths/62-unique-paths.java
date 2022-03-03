class Solution {
    public int uniquePaths(int m, int n) {
       int dp[][] = new int[m][n];
        return call(0,0,m,n,dp);
    }
    public int call(int i, int j, int m , int n, int[][] dp)
    {
        if(i==m||j==n)
            return 0;
        if(i==m-1&&j==n-1)
            return 1; 
        if(dp[i][j]!=0)
            return dp[i][j];
        int l1 =  call(i+1,j,m,n,dp);
        int l4 =  call(i,j+1,m,n,dp);
        return dp[i][j]=l1+l4;
    }
}