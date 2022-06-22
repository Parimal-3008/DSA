class Solution {
    public double champagneTower(int k, int r, int c) {
      double dp[][]= new double[r+1][c+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1.0);
        return Math.min(1.0,call((double)k,r,c,dp));
    }
    public double call(double k, int r, int c,double dp[][])
    {
        if(k<0|| c<0 || c>r)
            return 0;
        if(r==0 && c==0)
            return k;
        if(dp[r][c]!=-1.0)
            return dp[r][c];
        double left = (call(k,r-1,c,dp)-1.0)/2.0;
        double right = (call(k,r-1,c-1,dp)-1.0)/2.0;
        if(left<0)
            left = 0;
        if(right<0)
            right =0;
        return dp[r][c]=left+right;
    }
}