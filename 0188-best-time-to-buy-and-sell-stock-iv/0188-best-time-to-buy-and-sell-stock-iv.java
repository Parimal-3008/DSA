class Solution {
    public int maxProfit(int k, int[] arr) {
        int[][][] dp = new int[arr.length][2][k+1];
        for(int[][] oi:dp)
            for(int[] j:oi)
                Arrays.fill(j,-1);
        return call(0,0,k,arr,dp);
    }
    public int call(int i, int j, int k,int[] arr,int[][][] dp)
    {
        if(i==arr.length || k==0)
            return 0;
        if(dp[i][j][k]!=-1)
            return dp[i][j][k];
        if(j==0)
        {
            int a = -arr[i]+call(i+1,1,k,arr,dp);
            int b = call(i+1,0,k,arr,dp);
            return dp[i][j][k]=Math.max(a,b);
        }
        else
        {
             int a = arr[i]+call(i+1,0,k-1,arr,dp);
            int b = call(i+1,1,k,arr,dp);
            return dp[i][j][k]=Math.max(a,b);
        }
    }
}