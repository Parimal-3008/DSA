class Solution {
    public int minimizeTheDifference(int[][] arr, int k) {
        int[][] dp = new int[arr.length][10000];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return call(arr,k,0,dp);
    }
    public int call(int[][] arr, int k, int i,int[][] dp)
    {
        if(i==arr.length)
            return k;
        int ans = Integer.MAX_VALUE;
        if(dp[i][k+5000]!=-1)
            return dp[i][k+5000];
        for(int j=0;j<arr[i].length;j++)
        {
            ans = Math.min(ans,Math.abs(call(arr,k-arr[i][j],i+1,dp)));
        }
        return  dp[i][k+5000] = ans;
    }
}