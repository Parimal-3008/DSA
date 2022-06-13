class Solution {
    public int lengthOfLIS(int[] arr) {
        int dp[][] = new int[arr.length][arr.length+1];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        return call(arr,0,-1,dp);
    }
    public int call(int[] arr, int i,int prevind,int[][] dp)
    {
        if(i==arr.length)
            return 0;
        if(dp[i][prevind+1]!=-1)
            return dp[i][prevind+1];
        int a=0;
        if(prevind==-1||arr[i]>arr[prevind])
            a = 1+ call(arr,i+1,i,dp);
        int b = call(arr,i+1,prevind,dp);
        return dp[i][prevind+1] = Math.max(a,b);
    }
}