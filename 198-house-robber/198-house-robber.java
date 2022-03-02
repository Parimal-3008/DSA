class Solution {
    public int rob(int[] arr) {
        int[] dp= new int[arr.length+1];
        Arrays.fill(dp,-1);
        // for(int i=n-1;i>0;i--)
        // {
        //     int p = arr[i]+dp[n-2]
        // }
        return call(arr,dp,0);
    }
    public int call(int[] arr, int[] dp, int n)
    {
        if(n>=arr.length)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int p = arr[n]+call(arr,dp,n+2);
        int q = call(arr,dp,n+1);
        return dp[n]=Math.max(p,q);
    }
}