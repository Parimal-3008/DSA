class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return call(0,0,dp);
    }
    public int call(int i, int j,int[][] dp)
    {
        if(i==dp.length||j==dp[0].length)
            return 0;
        if(i==dp.length-1&&j==dp[0].length-1)
            return 1;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a = call(i+1,j,dp);
        int b = call(i,j+1,dp);
        return dp[i][j]=a+b;
    }
}