class Solution {
    public int maxProfit(int[] arr) {
        int[][][] dp = new int[arr.length][2][3];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                for(int k=0;k<dp[i][j].length;k++)
                    dp[i][j][k]=-1;
        return call(0,true,arr,0,dp);
    }
    public int call(int i,boolean camubuy,int[] arr, int count,int dp[][][])
    {
        if(i==arr.length)
            return 0;
        if(count==2)
            return 0;
        if(dp[i][camubuy?1:0][count]!=-1)
            return  dp[i][camubuy?1:0][count];
        int profit = Integer.MIN_VALUE;
        if(camubuy)
        {
            int a = -arr[i]+call(i+1,false,arr,count,dp);
            int b = call(i+1,true,arr,count,dp);
            profit = Math.max(a,b);
        }
        else
        {
             int a = arr[i]+call(i+1,true,arr,count+1,dp);
            int b = call(i+1,false,arr,count,dp);
            profit = Math.max(a,b);
        }
        return  dp[i][camubuy?1:0][count] = profit;
    }
}