class Solution {
    public int rob(int[] arr) {
        int[] dp= new int[arr.length+1];
        Arrays.fill(dp,-1);
        return call(arr,dp,arr.length-1);
    }
    public int call(int[] arr, int[] dp, int n)
    {
        if(n<0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int p = arr[n]+call(arr,dp,n-2);
        int q = call(arr,dp,n-1);
        return dp[n]=Math.max(p,q);
    }
}