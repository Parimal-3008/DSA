class Solution {
    public long maxAlternatingSum(int[] arr) {
        long dp[][]= new long[arr.length][2];
        for(long[] i:dp)
            Arrays.fill(i,-1);
        return call(arr,0,0,dp);
    }
    public long call(int[] arr, int i, int sign,long[][] dp)
    {
        if(i== arr.length)
            return 0;
        if(dp[i][sign]!=-1)
            return dp[i][sign];
        if(sign == 0)
        {
            long a = arr[i]+ call(arr,i+1,1,dp);
            long b= call(arr,i+1,0,dp);
            return dp[i][sign]= Math.max(a,b);
        }
        else
        {
             long a = -arr[i]+ call(arr,i+1,0,dp);
            long b= call(arr,i+1,1,dp);
            return dp[i][sign]=Math.max(a,b);
        }
    }
}