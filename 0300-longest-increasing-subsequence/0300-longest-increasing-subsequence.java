class Solution {
    public int lengthOfLIS(int[] arr) {
         int dp[][] = new int[arr.length][arr.length+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return call(arr,0,-1,dp);
    }
    public int call(int[] arr, int i, int prev, int[][] dp)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][prev+1]!=-1)
            return dp[i][prev+1];
        if(prev == -1)
        {
            int a = 1+call(arr,i+1,i,dp);
            int b = call(arr,i+1,-1,dp);
            return  dp[i][prev+1]=Math.max(a,b);
        }
        else
        {
            int a = 0;int b = 0;
            if(arr[i]>arr[prev])
                a= 1+ call(arr,i+1,i,dp);
            b = call(arr,i+1,prev,dp);
            return dp[i][prev+1]=Math.max(a,b);
        }
    }
}