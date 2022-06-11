class Solution {
    public int maxProfit(int[] arr, int k) {
        int dp[][] = new int[arr.length][2];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return call(0,true,arr,k,dp);
    }
    public int call(int i,boolean canubuy, int[] arr, int k,int[][] dp)
    {
        if(i==arr.length)
            return 0;
        int profit = Integer.MIN_VALUE;
        if(dp[i][canubuy?1:0]!=-1)
            return dp[i][canubuy?1:0];
        if(canubuy)
        {
            int a = -arr[i] +call(i+1,false,arr,k,dp);
            int b = call(i+1,true,arr,k,dp);
            profit = Math.max(a,b);
        }
        else
        {
            int a = arr[i] +call(i+1,true,arr,k,dp)-k;
            int b = call(i+1,false,arr,k,dp);
            profit = Math.max(a,b);
        }
        return dp[i][canubuy?1:0]=profit;
    }
}