class Solution {
    public double knightProbability(int n, int k, int r, int c) {
        double dp[][][] = new double[n][n][k+3];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                for(int p=0;p<3+k;p++)
                dp[i][j][p]=-1;
        return call(r,c,n,k,dp);
    }
    public double call(int i, int j,int n, int k,double[][][] dp)
    {
        if(i<0||j<0||i>=n||j>=n)
            return 0.0;
         if(dp[i][j][k]!=-1)
            return dp[i][j][k];
        if(k==0)
            return 1.0;
       
        double a1 = call(i+2,j+1,n,k-1,dp)/8.0;        
        double a2 = call(i+2,j-1,n,k-1,dp)/8.0;
        double a3 = call(i-2,j-1,n,k-1,dp)/8.0;
        double a4 = call(i-2,j+1,n,k-1,dp)/8.0;
        double a5 = call(i+1,j+2,n,k-1,dp)/8.0;
        double a6 = call(i+1,j-2,n,k-1,dp)/8.0;
        double a7 = call(i-1,j-2,n,k-1,dp)/8.0;
        double a8 = call(i-1,j+2,n,k-1,dp)/8.0;
        return dp[i][j][k]=a1+a2+a3+a4+a5+a6+a7+a8;
            
    }
}