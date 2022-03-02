class Solution {
    public int rob(int[] arr) {
        int[] dp= new int[arr.length+1];
        Arrays.fill(dp,0);
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            int p=arr[i];
            if(i>1)
             p = p+dp[i-2];
            int q = dp[i-1];
            dp[i]=Math.max(p,q);
        }
        return dp[arr.length-1];
        // return call(arr,dp,0);
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